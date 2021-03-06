package project7;

/**
 * A child Class "BookBibEntry" which inherits from its
 * parent class "AbstractBibEntry" and adds the attributes:
 * publisher, city (the city in which it was published) and
 * state (the state in which it was published)
 * @author Justin Homme
 * @version 03/29/21
 *
 */
public class BookBibEntry extends AbstractBibEntry {
	
	/**
	 * the name of the publisher
	 */
	private String publisher;
	
	/**
	 * the name of the city that the book
	 * was published in
	 */
	private String city;
	
	/**
	 * the name of the state that the book
	 * was published in
	 */
	private String state;
	
	/**
	 * a constructor for class "BookBibEntry" that inherits
	 * from its parent class "AbstractBibEntry"
	 * @param title
	 * @param author1_fname the first name of the 1st author of the book
	 * @param author1_lname the last name of the 1st author of the book
	 * @param author2_fname the first name of the 2nd author of the book
	 * @param author2_lname the last name of the 2nd author of the book
	 * @param etal a boolean value that tells us if there are more than 2 authors
	 * @param publisher the name of the book's publisher
	 * @param year the year in which the book was published
	 * @param city the city in which the book was published
	 * @param state the state in which the book was published
	 * @throws IllegalArgumentException if the publisher is null or an empty string, the city is null
	 * or an empty string, or the state is null or an empty string
	 */
	public BookBibEntry(String title, String author1_fname,
						String author1_lname, String author2_fname,
						String author2_lname, boolean etal, String publisher,
						int year, String city, String state) throws IllegalArgumentException {
		
		super(title, author1_fname, author1_lname, author2_fname, // inherits these from the
			  author2_lname, etal, year);						  // parent class "AbstractBibEntry"
		
		setPublisher(publisher);
		setCity(city);
		setState(state);
	}
	/**
	 * 
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher of the book
	 * @throws IllegalArgumentException if the publisher is null or an empty string
	 */
	public void setPublisher(String publisher) throws IllegalArgumentException {
		if(publisher == null || publisher.equals("")) {
			throw new IllegalArgumentException("The publisher may not be null or an empty string");
		}
		this.publisher = publisher;
	}
	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city the book was written in
	 * @throws IllegalArgumentException if the city is null or an empty string
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if(city == null || city.equals("")) {
			throw new IllegalArgumentException("The city cannot be null or an empty string");
		}
		this.city = city;
	}
	/**
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state the book was written in
	 * @throws IllegalArgumentException if the state is null or an empty string
	 */
	public void setState(String state) throws IllegalArgumentException {
		if(state == null || state.equals("")) {
			throw new IllegalArgumentException("The state cannot be null or an empty string");
		}
		this.state = state;
	}
	
}