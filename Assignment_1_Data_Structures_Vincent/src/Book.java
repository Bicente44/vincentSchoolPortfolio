
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

/**
 * This class
 * 
 * @author Vincent Welbourne
 * 
 */
import java.util.Scanner;

/**
 * Represents a generic book in the library system.
 */
public class Book {
	/**
	 * bookCode
	 */
	protected int bookCode;
	/**
	 * title
	 */
	protected String title;
	/**
	 * author
	 */
	protected String author;
	/**
	 * genre
	 */
	protected String genre;
	/**
	 * quantityInStock
	 */
	protected int quantityInStock;
	/**
	 * totalQuantity
	 */
	protected int totalQuantity;

	/**
	 * Book constructor
	 */
	public Book() {

	}

	/**
	 * toString
	 * 
	 * @return A string showing book code, title, quantity, author, and genre.
	 */
	@Override
	public String toString() {
		return "Book: " + bookCode + " " + title + " " + quantityInStock + " Author: " + author + " Genre: " + genre;
	}

	/**
	 * Updates the quantity in stock by the given amount. Returns false if it would
	 * go below zero.
	 * 
	 * @param amount The change in stock quantity (positive or negative).
	 * @return true if the update is valid and successful; false otherwise.
	 */
	public boolean updateQuantity(int amount) {
		if (quantityInStock + amount < 0) {
			return false;
		}
		quantityInStock += amount;
		return true;
	}

	/**
	 * Checks if this book is equal to another book (by title and author).
	 *
	 * @param book The book to compare with.
	 * @return true if both books have the same title and author; false otherwise.
	 */
	public boolean isEqual(Book book) {
		return title.equals(book.title) && author.equals(book.author);
	}

	/**
	 * Prompts the user to enter all the book details: code, title, author, and
	 * quantity. Validates if input is proper.
	 * 
	 * @param scanner Scanner object for user input.
	 * @return true if input is successful and valid; false otherwise.
	 */
	public boolean addBook(Scanner scanner) {
		// Book Code
		System.out.print("Enter the code for the book: ");
		while (true) {
			String codeInput = scanner.nextLine();
			try {
				this.bookCode = Integer.parseInt(codeInput);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry");
				System.out.print("Enter the code for the book: ");
			}
		}
		// Title
		System.out.print("Enter the title of the book: ");
		this.title = scanner.nextLine();
		// Author
		System.out.print("Enter the author of the book: ");
		this.author = scanner.nextLine();
		// Quantity
		System.out.print("Enter the quantity of the book: ");
		while (true) {
			String quantityInput = scanner.nextLine();
			try {
				this.quantityInStock = Integer.parseInt(quantityInput);
				if (this.quantityInStock < 0) {
					System.out.println("Invalid quantity.");
					System.out.print("Enter the quantity of the book: ");
					continue;
				}
				// Store original total quantity
				this.totalQuantity = this.quantityInStock;
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid quantity.");
				System.out.print("Enter the quantity of the book: ");
			}
		}
		return true;
	}

	/**
	 * Prompts the user to enter just the book code (used for checking duplicates or
	 * identification).
	 * 
	 * @param scanner Scanner object for user input.
	 * @return true if a valid integer code is entered; false otherwise.
	 */
	public boolean inputCode(Scanner scanner) {
		System.out.print("Enter the code for the book: ");
		if (!scanner.hasNextInt()) {
			scanner.nextLine(); // clear invalid input
			System.out.println("Invalid entry");
			return false;
		}
		bookCode = scanner.nextInt();
		scanner.nextLine(); // consume newline
		return true;
	}

}
