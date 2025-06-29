
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
import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a generic book in the library system.
 */
public class Book {
	/**
	 * Unique integer code identifying a book.
	 */
	protected int bookCode;
	/**
	 * title of the book
	 */
	protected String title;
	/**
	 * author of the book
	 */
	protected String author;
	/**
	 * Genre of the book (Fiction, NonFiction, Reference).
	 */
	protected String genre;
	/**
	 * Current quantity in stock (available to borrow).
	 */
	protected int quantityInStock;
	/**
	 * Total quantity ever added to stock for this book.
	 */
	protected int totalQuantity;

	/**
	 * Default constructor. Creates an empty Book instance
	 */
	public Book() {

	}

	/**
	 * 
	 * A constructor to create a Book with basic fields.
	 * 
	 * @param bookCode        unique code for the book
	 * @param title           title of the book
	 * @param author          author of the book
	 * @param quantityInStock initial stock quantity
	 */
	public Book(int bookCode, String title, String author, int quantityInStock) {
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.quantityInStock = quantityInStock;
	}

	/**
	 * toString a readable representation of the book including code, title, stock,
	 * author, and genre.
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
	 * Checks if this book is equal to another book.
	 *
	 * @param book The book to compare with.
	 * @return Returning true or false if the book is the same.
	 */
	public boolean isEqual(Book book) {
		return bookCode == book.bookCode;
	}

	/**
	 * Prompts the user to enter all the book details: code, title, author, and
	 * quantity. Validates if input is proper.
	 * 
	 * @param scanner  Scanner object for user input.
	 * @param fromFile true if called during file read.
	 * @return true if input is successful and valid; false otherwise.
	 */
	public boolean addBook(Scanner scanner, boolean fromFile) {
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
	 * @param scanner  Scanner object for user input.
	 * @param fromFile true if called during file read
	 * @return true if a valid integer code is entered; false otherwise.
	 */
	public boolean inputCode(Scanner scanner, boolean fromFile) {
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

	/**
	 * 
	 * Writes this Book’s data to the given Formatter
	 * 
	 * @param writer Formatter wrapping the output file or stream
	 */
	public void outputBook(Formatter writer) {
		writer.format("%d%n", bookCode);
		writer.format("%s%n", title);
		writer.format("%d%n", quantityInStock);
		writer.format("%s%n", author);
		writer.format("%s%n", genre);
	}

}
