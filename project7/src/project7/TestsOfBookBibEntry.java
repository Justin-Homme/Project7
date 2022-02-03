package project7;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;



/**
 * Some simple tests of the BookBibEntry class. You'll want to add more tests
 * yourself.
 * 
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 */
class TestsOfBookBibEntry {

	/**
	 * Make sure legal values don't generate an exception. If an exception is
	 * thrown, the test will be marked as "failed" since we don't bother catching
	 * it.
	 */
	@Test
	void testLegalVals() {
		// the authors of our textbook are actually both named Ralph, but I'm renaming
		// one of them Rafe since that's a better test
		BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
				"Independent", 2017, "Hartford", "CT");
		// If you want a custom error message on failure, you can do this
		assertEquals("Title not set", "Java, Java, Java", book.getTitle());
		// or you can be lazy and just go with the default "didn't match" message
		assertEquals("Ralph", book.getAuthor1_fname());
		assertEquals("Morelli", book.getAuthor1_lname());
		assertEquals("Rafe", book.getAuthor2_fname());
		assertEquals("Walde", book.getAuthor2_lname());
		assertFalse(book.isEtal());
		assertEquals("Independent", book.getPublisher());
		assertEquals(2017, book.getYear());
		assertEquals("Hartford", book.getCity());
		assertEquals("CT", book.getState());

		book.setEtal(true);
		assertTrue(book.isEtal());
		book.setAuthor1name(null, null);
		assertTrue(book.isEtal());
		assertEquals("Rafe", book.getAuthor1_fname());
		assertEquals("Walde", book.getAuthor1_lname());
		assertNull(book.getAuthor2_fname());
		assertNull(book.getAuthor2_lname());
		book.setAuthor1name(null, null);
		assertFalse(book.isEtal());
		assertNull(book.getAuthor1_fname());
		assertNull(book.getAuthor1_lname());
		assertNull(book.getAuthor2_fname());
		assertNull(book.getAuthor2_lname());

		book.setYear(1999);
		assertEquals(1999, book.getYear());
		book.setPublisher("Trinity Press");
		assertEquals("Trinity Press", book.getPublisher());
		book.setCity("New Haven");
		assertEquals("New Haven", book.getCity());
		book.setState("MN");
		assertEquals("MN", book.getState());
	}

	/**
	 * Make sure a blank title throws an exception in the constructor
	 */
	@Test
	void testNullString() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> { // this is something called a lambda expression
						// the code that will throw an exception when run
					BookBibEntry book = new BookBibEntry("", "Ralph", "Morelli", "Rafe", "Walde", false, "Independent",
							2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a null title throws an exception in the constructor
	 */
	@Test
	void testTitleNullConstructor() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry(null, "Ralph", "Morelli", "Rafe", "Walde", false,
							"Independent", 2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a blank title throws an exception in the setter
	 */
	@Test
	void testTitleBlankSetter() {
		BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
				"Independent", 2017, "Hartford", "CT");
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					book.setTitle("");
				});
	}

	/**
	 * Make sure a null title throws an exception in the setter
	 */
	@Test
	void testTitleNullSetter() {
		BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
				"Independent", 2017, "Hartford", "CT");
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					book.setTitle(null);
				});
	}

	/**
	 * Make sure a null first name and non-null last name throws an exception in the
	 * constructor
	 */
	@Test
	void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", null, "Morelli", "Rafe", "Walde", false,
							"Independent", 2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a null last name and non-null first name throws an exception in the
	 * constructor
	 */
	@Test
	void testNullLastName() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", null, "Rafe", "Walde", false,
							"Independent", 2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a null first author and non-null second author throws an exception
	 * in the constructor
	 */
	@Test
	void testNoFirstOnlySecondAuthor() {
		assertThrows(IllegalStateException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", null, null, "Rafe", "Walde", false,
							"Independent", 2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a first author with no second author doesn't throw an exception
	 */
	@Test
	void testNoSecondOnlyFirstAuthor() {
		BookBibEntry book = new BookBibEntry("Java, Java, Java", "Rafe", "Walde", null, null, false, "Independent",
				2017, "Hartford", "CT");

	}

	/**
	 * Make sure that not having any authors doesn't allow et al to be true
	 */
	@Test
	void testEtAlNoAuthor() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", null, null, null, null, true,
							"Independent", 2017, "Hartford", "CT");
				});
	}

	/**
	 * Shoudl not throw an exception for one author and et al according to our rules
	 */
	@Test
	void testEtAlOneAuthor() {
		BookBibEntry book = new BookBibEntry("Java, Java, Java", "Rafe", "Walde", null, null, true, "Independent", 2017,
				"Hartford", "CT");

	}

	/**
	 * Make sure a null city throws an exception in the constructor
	 */
	@Test
	void testNullCity() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
							"Independent", 2017, null, "CT");
				});
	}

	/**
	 * Make sure a null publisher throws an exception in the constructor
	 */
	@Test
	void testNullPublisher() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
							null, 2017, "Hartford", "CT");
				});
	}

	/**
	 * Make sure a null state throws an exception in the constructor
	 */
	@Test
	void testNullState() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
					BookBibEntry book = new BookBibEntry("Java, Java, Java", "Ralph", "Morelli", "Rafe", "Walde", false,
							"Independent", 2017, "Hartford", null);
				});
	}

}