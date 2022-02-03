package project7;
/**
 * A parent class "AbstractBibEntry" for child classes
 * (in this case, it will be "BookBibEntry" and "JournalBibEntry"
 * but other child classes could be made) to utilize and expand/
 * improve upon
 * @author Justin Homme
 * @version 03/29/21
 *
 */
public abstract class AbstractBibEntry {
	
	/**
	 * the title of the Citation
	 */
	protected String title;
	
	/**
	 * the first name of the 1st author
	 */
	protected String author1_fname;
	
	/**
	 * the last name of the 1st author
	 */
	protected String author1_lname;
	
	/**
	 * the first name of the 2nd author
	 */
	protected String author2_fname;
	
	/**
	 * the last name of the 2nd author
	 */
	protected String author2_lname;
	
	/**
	 * a boolean value which tells whether or not there 
	 * are more than two authors
	 */
	protected boolean etal;
	
	/**
	 * the year of publication
	 */
	protected int year;
	
	/**
	 * a constructor for class "AbstractBibEntry"
	 * @param title
	 * @param author1_fname 1st author's first name
	 * @param author1_lname 1st author's last name
	 * @param author2_fname 2nd author's first name
	 * @param author2_lname 2nd author's last name
	 * @param etal a boolean value which tells if there are more than 2 authors
	 * @param year the year it was published
	 * @throws IllegalArgumentException if the name of the title is null or an empty string,
	 * if author 1 or 2 has a legal first name without a legal last name, author 1 or 2 has 
	 * a legal last name without a legal first name, author 1 and 2 are null or empty and etal
	 * is set to true, or the year is negative
	 * @throws IllegalStateException if author one is null or empty but author 2 has a valid name 
	 */
	public AbstractBibEntry(String title, String author1_fname,
							String author1_lname, String author2_fname,
							String author2_lname, boolean etal, int year) throws IllegalArgumentException, IllegalStateException {
		setTitle(title);
		setAuthor1name(author1_fname, author1_lname);
		setAuthor2name(author2_fname, author2_lname);
		setEtal(etal);
		setYear(year);
	}
	/**
	 * @return title the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to be set
	 * @throws IllegalArgumentException if the title is null or an empty string
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if(title == null || title.equals("")) {
			throw new IllegalArgumentException("The title cannot be null or an empty string.");
		}
		this.title = title;
	}
	/**
	 * @return author1_fname the first name of author 1
	 */
	public String getAuthor1_fname() {
		return author1_fname;
	}
	/**
	 * @param author1_fname, author1_lname the first name of the primary author
	 * and the last name of the primary author
	 * @throws IllegalArgumentException if the author has a legal first name without a legal last name or the author has 
	 * a legal last name without a legal first name
	 */
	public void setAuthor1name(String author1_fname, String author1_lname) throws IllegalArgumentException {
		if((author1_fname != null && !author1_fname.equals("")) && (author1_lname == null || author1_lname.equals(""))) {
			throw new IllegalArgumentException("The author cannot have a first name without a last name");
			// Author 1 has a legal first name but no legal last name
		}else if((author1_lname != null && !author1_lname.equals("")) && (author1_fname == null || author1_fname.equals(""))) {
			throw new IllegalArgumentException("The author cannot have a last name without a first name");
			// Author 1 has a legal last name but no legal first name
		}else if(((author1_fname == null || author1_fname.equals("")) && (author1_lname == null || author1_lname.equals("")))
				&& ((author2_fname != null && !author2_fname.equals("")) && (author2_lname != null && !author2_lname.equals("")))) {
			this.author1_fname = this.author2_fname;
			this.author1_lname = this.author2_lname;
			this.author2_fname = author1_fname;
			this.author2_lname = author1_lname;
			// Author 1 is null or blank but author 2 has a legal name
		}else if(((author1_fname == null || author1_fname.equals("")) && (author1_lname == null || author1_lname.equals(""))) && 
				((author2_fname == null || author2_fname.equals("")) && (author2_lname == null || author2_lname.equals("")))) {
			setEtal(false);
			this.author1_fname = author1_fname;
			this.author1_lname = author1_lname;
			// if Author 1 is null or blank and Author 2 is null or blank etal must be false
		}else {
			this.author1_fname = author1_fname;
			this.author1_lname = author1_lname;
		}
	}
	/**
	 * @return author1_lname the last name of author 1
	 */
	public String getAuthor1_lname() {
		return author1_lname;
	}
	/**
	 * @return author2_fname the first name of author 2
	 */
	public String getAuthor2_fname() {
		return author2_fname;
	}
	/**
	 * @param author2_fname, author2_lname the first name of the secondary
	 * author and the last name of the secondary author
	 * @throws IllegalStateException if the first author is null or empty and author 2 is not null or empty (since you cannot 
	 * have a second author without a first author) 
	 * @throws IllegalArgumentException if the first name of the second author is valid but the last name is null or an empty string 
	 * or if the last name of the second author is valid but the first name is null or an empty string
	 */
	public void setAuthor2name(String author2_fname, String author2_lname) throws IllegalStateException, IllegalArgumentException {
		if(((author1_fname == null || author1_fname.equals("")) && (author1_lname == null || author1_lname.equals(""))) && 
				((author2_fname != null && !author2_fname.equals("")) || (author2_lname != null && !author2_lname.equals("")))) {
			throw new IllegalStateException("You cannot set an author 2 without an author 1");
			// Author 2 has a legal name but Author 1 does not have a legal name
		}else if((author2_fname != null && !author2_fname.equals("")) && (author2_lname == null || author2_lname.equals(""))) {
			throw new IllegalArgumentException("The author cannot have a first name without a last name");
			// Author 2 has a legal first name but no legal last name
		}else if((author2_lname != null && !author2_lname.equals("")) && (author2_fname == null || author2_fname.equals(""))) {
			throw new IllegalArgumentException("The author cannot have a last name without a first name");
			// Author 2 has a legal last name but no legal first name
		}
		this.author2_fname = author2_fname;
		this.author2_lname = author2_lname;
	}
	/**
	 * @return author2_lname the last name of author 2
	 */
	public String getAuthor2_lname() {
		return author2_lname;
	}
	/**
	 * @return etal whether there is more than 2 authors or not
	 */
	public boolean isEtal() {
		return etal;
	}
	/**
	 * @param etal a boolean value which tells if there are more than 2 authors
	 * @Throws IllegalArgumentException if both author 1 and author 2 are null or empty and etal is true
	 */
	public void setEtal(boolean etal) throws IllegalArgumentException {
		if(((author1_fname == null || author1_fname.equals("")) && (author1_lname == null || author1_lname.equals(""))) && 
				((author2_fname == null || author2_fname.equals("")) && (author2_lname == null || author2_lname.equals("")))
				&& (etal == true)){
			throw new IllegalArgumentException("Etal cannot be true if both authors are null or blank");
			// Etal is set to true but both authors are null or blank
		}
		this.etal = etal;
	}
	/**
	 * @return year the year of publishing
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year it was published
	 * @throws IllegalArgumentException if the year is negative
	 */
	public void setYear(int year) {
		if(year < 0) {
			throw new IllegalArgumentException("The year cannot be negative");
			// the year is set to a negative value
		}
		this.year = year;
	}
	
	
}