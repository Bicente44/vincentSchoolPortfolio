
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Vincent Welbourne
 * Student Number: 041161454
 * Section #: 312
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * 
 */

import java.util.Scanner;
import java.util.Formatter;

/**
 * Represents a Reference book in the library. This class is a extension of the
 * Book class. It automatically sets the genre to "Reference".
 * 
 * @author Vincent Welbourne
 */
public class ReferenceBook extends Book {

	/**
	 * Edition
	 */
	protected String edition;

	/**
	 * Default constructor that initializes the genre as "Edition".
	 */
	public ReferenceBook() {
		super();
		this.genre = "Reference";
	}
	
	/**
	 * 
	 * A constructor that creates ReferenceBook with basic fields.
	 * 
	 * @param bookCode integer code identifying a book.
	 * @param title Book title
	 * @param quantity Quantity of books
	 * @param author Author of book
	 * @param edition Edition of book unique for Reference Books
	 */
	public ReferenceBook(int bookCode, String title, int quantity, String author, String edition) {
		super(bookCode, title, author, quantity);
		this.edition = edition;
	}

	/**
	 * Prompts the user to enter book details specific to Reference books.
	 *
	 * @param scanner The Scanner object to read user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	@Override
	public boolean addBook(Scanner scanner, boolean fromFile) {
		if (!super.addBook(scanner, fromFile)) {
			return false;
		}
		System.out.print("Enter the edition of the book: ");
		edition = scanner.nextLine();
		return true;
	}

	/**
	 * Returns a string representation of the FictionBook.
	 * 
	 * @return A string containing book code, title, quantity, author, and genre.
	 */
	@Override
	public String toString() {
		return super.toString() + " Edition: " + edition;
	}

	/**
	 * Writes this ReferenceBook. The leading “r” identifies the type as reference.
	 * 
	 * @param writer Formatter wrapping the output file or stream
	 */
	@Override
	public void outputBook(Formatter writer) {
		writer.format("r%n");
		super.outputBook(writer); // code, title, quantity, author, genre
		writer.format("%s%n", edition); // extra type
	}
}
