package project7;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

/**
 * Some simple tests of the JournalBibEntry class.
 * You'll want to add more tests yourself.
 * 
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 */
class TestsOfJournalBibEntry {
	
	/**
	 * Make sure legal values don't generate an exception.  If an exception
	 * is thrown, the test will be marked as "failed" since we don't bother
	 * catching it.
	 */
	@Test
	void testLegalVals(){
		//The actual issue number is 1, but I'm setting it to 2 for a better test
		JournalBibEntry ja = new JournalBibEntry("Real-time procedural textures", "John", "Rhoades",
				"Greg", "Turk", true, "Proceedings of the 1992 Symposium on Interactive 3D Graphics",
				1992, 1, 2, 95, 100, "http://doi.acm.org/10.1145/147156.147171");
		
		assertEquals("Real-time procedural textures", ja.getTitle());
		//or you can be lazy and just go with the default "didn't match" message
		assertEquals("John", ja.getAuthor1_fname());
		assertEquals("Rhoades", ja.getAuthor1_lname());
		assertEquals("Greg", ja.getAuthor2_fname());
		assertEquals("Turk", ja.getAuthor2_lname());
		assertTrue(ja.isEtal());
		assertEquals("Proceedings of the 1992 Symposium on Interactive 3D Graphics", ja.getJournal());
		assertEquals(1992, ja.getYear());
		assertEquals(1, ja.getIssue());
		assertEquals(2, ja.getVolume());
		assertEquals(95, ja.getPageStart());
		assertEquals(100, ja.getPageEnd());
		assertEquals("http://doi.acm.org/10.1145/147156.147171", ja.getDoi());
		
		
		
		ja.setYear(1999);
		assertEquals(1999, ja.getYear());
		ja.setJournal("SIGGRAPH");
		assertEquals("SIGGRAPH", ja.getJournal());
		ja.setVolume(42);
		assertEquals(42, ja.getVolume());
		ja.setIssue(57);
		assertEquals(57, ja.getIssue());
		ja.setPages(17, 20);
		assertEquals(17, ja.getPageStart());
		assertEquals(20, ja.getPageEnd());
		ja.setDoi("hello");
		assertEquals("hello", ja.getDoi());
	}
	
		
	
	
	/**
	 * Make sure a null Journal title
	 *  throws an exception in the constructor
	 */
	@Test
	void testNullJournal() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
		JournalBibEntry ja = new JournalBibEntry("Real-time procedural textures", "John", "Rhoades",
				"Greg", "Turk", true, null,
				1992, 1, 2, 95, 100, "http://doi.acm.org/10.1145/147156.147171");
				});
	}
	
	/**
	 * Make sure a blank DOI
	 *  throws an exception in the constructor
	 */
	@Test
	void testBlankDOI() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
		JournalBibEntry ja = new JournalBibEntry("Real-time procedural textures", "John", "Rhoades",
				"Greg", "Turk", true, "Proceedings of the 1992 Symposium on Interactive 3D Graphics",
				1992, 1, 2, 95, 100, "");
				});
	}
	
	/**
	 * Make sure a null state
	 *  throws an exception in the constructor
	 */
	@Test
	void testBadPageNumbers() {
		assertThrows(IllegalArgumentException.class, // type of exception we're expecting
				() -> {
		JournalBibEntry ja = new JournalBibEntry("Real-time procedural textures", "John", "Rhoades",
				"Greg", "Turk", true, "Proceedings of the 1992 Symposium on Interactive 3D Graphics",
				1992, 1, 2, 100, 95, "http://doi.acm.org/10.1145/147156.147171");
				});
	}

}
