package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author harsh
 * Crawler gets all the related URLs to the query submitted 
 * 
 */
public class CrawlerModel {
	/**
	 * Set to get all the unique Urls available from the query passed.
	 */
	private Set<String> Urls;
	/**
	 * 
	 * random number generator object to make random input data for priority
	 */
	public Random rn = new Random(System.currentTimeMillis());

	/**
	 * Constructor
	 * 
	 */
	public CrawlerModel() {
		Urls = new HashSet<>();
	}

    /**
     * matches the given string query to the urls.
     * 
     */
    private static Matcher matcher;
    /**
     * determines the regex of how a domain should be.
     * 
     */
    private static final String DOMAIN_NAME_PATTERN
            = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,15}";
    /**
     * 
     * Makes a pattern from the regex.
     */
    private static Pattern patrn = Pattern.compile(DOMAIN_NAME_PATTERN);

    /**
     * gets the domain if the query matches in it Html document.
     * @param url Url 
     * @return domain String
     */
    public static String getDomainName(String url) {

        String domainName = "";
        matcher = patrn.matcher(url);

        if (matcher.find()) {
            domainName = matcher.group(0).toLowerCase().trim();
        }

        return domainName;
    }

    /**
     * Gets all the url for a given query and adds them to a private set of the crawler class.
     * 
     * @param query the search string.
     * @throws IOException if the connection is not formed.
     */
    public void getURLS(String query) throws IOException{
          String url = "https://www.google.com/search?q=" + query + "&num=500";

          Document doc = Jsoup
                  .connect(url)
                  .userAgent("Jsoup client")
                  .get();

          Elements links = doc.select("a[href]");

       
          for (Element link : links) {

              String attr1 = link.attr("href");
              String attr2 = link.attr("class");

              if (!attr2.startsWith("_Zkb") && attr1.startsWith("/url?q=")) {
              	
                  Urls.add(getDomainName(attr1));
              }
              if(Urls.size()> 35) break;
          }
    }
    
    
    /**
     * generates an arraylist of the webUri holding all the priority with the following details:
     * The age of the webpage
     * the links related to other webpages
     * the frequency number is being repeated in a webpage
     * the indeex of the arraylist.
     * @return returns an arraylist filled with all the details. 
     */
    public ArrayList<WebURLModel> insertWebURIs() {
    	ArrayList<WebURLModel> urls = new ArrayList<>();
    	int i=0 ;
    	for(String el :  Urls) {
    		//int linked = getLinkedSites(el);
    		WebURLModel myURI = new WebURLModel(el,keywordsFrequency(), getrandomLinkNumberCount(), siteAge(), i);
    		myURI.generatePriority();
    		urls.add(myURI);
    		i++;
    	}
    	return urls;
    }
    
    /**
     * generates a random number of frequency the string appears in 
     * @return the number the query is found
     */
    public int keywordsFrequency() {
    	return rn.nextInt(100);
    }
    
    /**
   generates a random number of age the string appears in 
     * @return the number the website is aged.
     */
    public int siteAge() {
    	return rn.nextInt(100);
    }
    
    
    
    /**
     * Gets all the links which are related to the mainsite and has all query string input in them
     *
     * @param url Gets the url string to find all sub-web sites.
     * @return the number of websites having similar linked query outputs.
     */
    public int getLinkedSites(String url) {
    	 int count =0 ;
    	if(url.startsWith("www"))
    		{url = url.replaceAll("www.", "http://");}
    	else {
    		
    		url = "http://".concat(url);
    		
    	}try {
    		Connection.Response response = Jsoup.connect(url).userAgent("Mozilla").ignoreContentType(true).ignoreHttpErrors(true).timeout(10000).execute();

    		Document document = ((Connection) response).get();
    		Elements links = document.select("a[href]");
           
            for (Element link : links) {

            	if(link.attr("href") != null) {
            		count++;
            	}
            }

    	}catch(Exception e) {
    		return rn.nextInt(101);
    	}
    	
  
                    return count;
    }
    
    /**
     * generates a random number of linked websites  the string appears in 
     * @return the number the query is found in sub websites.
     */
    public int getrandomLinkNumberCount() {
    	return rn.nextInt(101);
    }
    
    

}