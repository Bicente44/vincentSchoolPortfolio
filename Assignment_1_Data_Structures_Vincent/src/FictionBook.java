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
 * Represents a Fiction book in the library. This class is a extension of
 * the Book class. It automatically sets the genre to "Fiction".
 * 
 * @author Vincent
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
	 * Returns a string representation of the FictionBook.
	 * 
	 * @return A string containing book code, title, quantity, author, and genre.
	 */
	@Override
	public String toString() {
		return "Book: " + bookCode + " " + title + " " + quantityInStock + " Author: " + author + " Genre: " + genre;
	}

	/**
	 * Prompts the user to enter book details specific to Fiction books.
	 *
	 * @param scanner The Scanner object to read user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	@Override
	public boolean addBook(Scanner scanner) {
		return super.addBook(scanner);
	}
}