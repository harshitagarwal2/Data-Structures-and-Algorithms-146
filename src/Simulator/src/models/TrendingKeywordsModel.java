package models;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TrendingKeywordsModel {

	public ArrayList<String> getTrends(){
		ArrayList<String> myList = new ArrayList<>();
	try {
		Document doc = Jsoup.connect("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US")
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .get();
		
		  Elements links = doc.select("item");
	      for (Element link : links) {
	    	  myList.add(link.getElementsByTag("title").text());
	      }	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return myList;
}
	
}
