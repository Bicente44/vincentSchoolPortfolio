
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
 * Represents a Fiction book in the library. This class is a extension of the
 * Book class. It automatically sets the genre to "Fiction".
 * 
 * @author Vincent Welbourne
 */
public class FictionBook extends Book {

	/**
	 * Default constructor that initializes the genre as "Fiction".
	 */
	public FictionBook() {
		super();
		this.genre = "Fiction";
	}
	/**
	 * 
	 * A constructor that creates FictionBook with basic fields.
	 * 
	 * @param bookCode integer code identifying a book.
	 * @param title Book title
	 * @param quantity Quantity of books
	 * @param author Author of book
	 */
	public FictionBook(int bookCode, String title, int quantity, String author) {
		super(bookCode, title, author, quantity);
	}

	/**
	 * Prompts the user to enter book details specific to Fiction books.
	 *
	 * @param scanner The Scanner object to read user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	@Override
	public boolean addBook(Scanner scanner, boolean fromFile) {
		return super.addBook(scanner, fromFile);
	}

	/**
	 * Returns a string representation of the FictionBook.
	 * 
	 * @return A string containing book code, title, quantity, author, and genre.
	 */
	@Override
	public String toString() {
		return "Book: " + bookCode + " " + title + " " + quantityInStock + " Author: " + author + " Genre: " + genre;
	}

	/**
	 * Writes this FictionBook to the given Formatter
	 * The leading “f” identifies the type as fiction.
	 * 
	 * @param writer Formatter wrapping the output file or stream
	 */
	@Override
	public void outputBook(Formatter writer) {
		writer.format("f%n");
		super.outputBook(writer); // bookCode, title, quantity, author, genre
	}
}
