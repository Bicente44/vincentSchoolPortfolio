
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
 * Represents a Non-Fiction book in the library. This class is a extension of
 * the Book class. It automatically sets the genre to "Non-Fiction".
 * 
 * @author Vincent Welbourne
 */
public class NonFictionBook extends Book {

	/*
	 * fieldOfStudy
	 */
	protected String fieldOfStudy;

	/**
	 * Default constructor that initializes the genre as "NonFiction".
	 */
	public NonFictionBook() {
		super();
		this.genre = "NonFiction";
	}

	/**
	 * 
	 * A constructor that creates NonFictionBook with basic fields.
	 * 
	 * @param bookCode integer code identifying a book.
	 * @param title Book title
	 * @param quantity Quantity of books
	 * @param author Author of book
	 * @param fieldOfStudy Field of Study unique to non-fiction Books
	 */
	public NonFictionBook(int bookCode, String title, int quantity, String author, String fieldOfStudy) {
		super(bookCode, title, author, quantity);
		this.fieldOfStudy = fieldOfStudy;
	}

	/**
	 * Prompts the user to enter book details specific to NonFiction books.
	 *
	 * @param scanner The Scanner object to read user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	@Override
	public boolean addBook(Scanner scanner, boolean fromFile) {
		if (!super.addBook(scanner, fromFile)) {
			return false;
		}
		System.out.print("Enter the field of study: ");
		fieldOfStudy = scanner.nextLine();
		return true;
	}

	/**
	 * Returns a string representation of the FictionBook.
	 * 
	 * @return A string containing book code, title, quantity, author, and genre.
	 */
	@Override
	public String toString() {
		return super.toString() + " Field of Study: " + fieldOfStudy;
	}

	/**
	 * Writes the NonFictionBook. The leading “n” identifies the type as
	 * non-fiction.
	 * 
	 * @param writer Formatter wrapping the output file or stream
	 */
	@Override
	public void outputBook(Formatter writer) {
		writer.format("n%n");
		super.outputBook(writer); // bookCode, title, quantity, author, genre
		writer.format("%s%n", fieldOfStudy); // extra type
	}
}
