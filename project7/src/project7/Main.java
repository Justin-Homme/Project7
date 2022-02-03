package project7;

public class Main {
	
	public static void main(String[] args) {
		
		BookBibEntry successBook = new BookBibEntry("To Kill a Mockingbird", "Harper", "Lee", null,
				null, false, "J.B. Lippincott & Co.", 1960, "Philadelphia", "Pennsylvania");
		// Just a normal book that should not cause issues
		try {
			BookBibEntry failBook = new BookBibEntry("To Kill a Mockingbird", null, null, "Harper",
				"Lee", false, "J.B. Lippincott & Co.", 1960, "Philadelphia", "Pennsylvania");
			// Tries to make a book with a second author and no first author
			System.out.println("Something went wrong.");
		}catch (IllegalStateException e) { // Catches the thrown exception and issues a success statement
			System.out.println("Successfully caught the bad author");
		}
		
		JournalBibEntry successJournal = new JournalBibEntry("Random Journal", "John", "Doe","Jane", "Doe",
				true, "Journal name", 2021, 1, 3, 0, 1, "http://doi.acm.org/10.1145/147156.147171"); //uses the DOI from the test case
		// creates a random Journal which should not cause issues									 //because I didn't know what else to use
		try{																		
			successJournal.setPages(5, 1);
			// sets start page to a value greater than the end page
			System.out.println("Something went wrong.");
		}catch (IllegalArgumentException ex) { // catches the thrown exception and issues a success statement
			System.out.println("Successfully caught the bad page number");
		}
	}

}
