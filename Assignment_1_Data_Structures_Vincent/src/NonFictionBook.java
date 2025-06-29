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

/**
 * Represents a Non-Fiction book in the library. This class is a extension
 * of the Book class. It automatically sets the genre to "Non-Fiction".
 * 
 * @author Vincent Welbourne
 */
public class NonFictionBook extends Book {

	private String fieldOfStudy;

	/**
	 * Default constructor that initializes the genre as "NonFiction".
	 */
	public NonFictionBook() {
		super();
		this.genre = "NonFiction";
	}

	/**
	 * Prompts the user to enter book details specific to NonFiction books.
	 *
	 * @param scanner The Scanner object to read user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	@Override
	public boolean addBook(Scanner scanner) {
		if (!super.addBook(scanner)) {
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
}
