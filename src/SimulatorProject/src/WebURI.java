

/**
 * @author harsh
 * WebUrl object to hold the required information for the urls.
 */
public class WebURI implements Comparable<WebURI> {

	/**
	 * Data Instances
	 */
	private String URL;
	public double priority;
	private int frequency;
	private int age;
	private int links;
	private int money;
	private int index = 0;

	/*
	 * Constructor
	 */
	public WebURI(String URL, int frequency, int links, int age, int index) {
		this.URL = URL;
		this.index = index;
		this.frequency = frequency;
		this.links = links;
		this.age = age;
		this.money = 1;
		generatePriority();
	}

	/**
	 * getters
	 * @return urls
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * setters
	 * @param URL set
	 */
	public void setURL(String URL) {
		this.URL = URL;
	}

	/**
	 * getter
	 * @return priority
	 */
	public double getPriority() {
		return priority;
	}

	/**
	 * getter
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * setter
	 * @param URL sert
	 */
	public WebURI(String URL) {
		this.URL = URL;
	}

	/**
	 * setter
	 * @param index st
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return URL + ":[Priority::  " + priority + ", age:" + age + ", frequency: " + frequency + " ]";
	}

	/**
	 * A custom method to generate a priority with the given details about the website fetched from crawler
	 */
	public void generatePriority() {
		priority = .25 * frequency + .25 * age + .25 * links + .25 * money;
	}

	/**
	 * @return
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
		generatePriority();
	}

	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
		generatePriority();
	}

	/**
	 * @return
	 */
	public int getLinks() {
		return links;
	}

	/**
	 * @param links
	 */
	public void setLinks(int links) {
		this.links = links;
		generatePriority();
	}

	/**
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
		generatePriority();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(WebURI o) {
		if (this.priority > o.priority) {
			return 1;
		} else if (this.priority < o.priority) {
			return -1;
		}
		return 0;
	}

}
