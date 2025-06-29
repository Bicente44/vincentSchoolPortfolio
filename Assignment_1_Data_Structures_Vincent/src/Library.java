
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
 * This class manages a collection of books. It supports adding, borrowing, and
 * returning books via user input.
 * 
 * @author Vincent Welbourne
 * 
 */
public class Library {

	/**
	 * catalog -- an array of books named catalog
	 */
	private Book[] catalog;
	/**
	 * numBooks
	 */
	private int numBooks;

	/**
	 * Library -- Default constructor
	 */
	public Library() {
		catalog = new Book[20];
		numBooks = 0;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		String result = "Library Catalog:\n";
		for (int i = 0; i < numBooks; i++) {
			result += catalog[i].toString() + "\n";
		}
		return result;
	}

	/**
	 * Checks whether a given book already exists in the catalog using isEqual().
	 * 
	 * @param book The book to check against the existing catalog.
	 * @return true if the book exists, false otherwise.
	 */
	public boolean alreadyExists(Book book) {
		for (int i = 0; i < numBooks; i++) {
			if (catalog[i].isEqual(book)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new book to the library based on user input. The user selects the type
	 * of book, enters its code, and provides book details.
	 * 
	 * @param scanner The Scanner object for reading user input.
	 * @return true if the book is added successfully; false otherwise.
	 */
	public boolean addBook(Scanner scanner) {
		System.out.print("Do you wish to add a Fiction(f), Non-Fiction(n), or Reference(r) book? ");
		String input = scanner.nextLine().trim().toLowerCase();

		while (!input.equals("f") && !input.equals("n") && !input.equals("r")) {
			System.out.println("Invalid input. Please enter a valid letter.");
			System.out.print("Do you wish to add a Fiction(f), Non-Fiction(n), or Reference(r) book? ");
			input = scanner.nextLine().trim().toLowerCase();
		}

		Book newBook;
		switch (input) {
		case "f":
			newBook = new FictionBook();
			break;
		case "n":
			newBook = new NonFictionBook();
			break;
		case "r":
			newBook = new ReferenceBook();
			break;
		default:
			return false;
		}
		if (newBook.addBook(scanner)) {
			if (alreadyExists(newBook)) {
				System.out.println("Book already exists in the catalog.");
				return false;
			}
			if (numBooks < catalog.length) {
				catalog[numBooks] = newBook;
				numBooks++;
				return true;
			} else {
				System.out.println("Catalog is full. Cannot add more books.");
				return false;
			}
		} else {
			System.out.println("Failed to add book.");
			return false;
		}
	}

	/**
	 * Attempts to borrow a book by decreasing its quantity by 1.
	 * 
	 * @param scanner Scanner to read the book code from the user.
	 * @return true if borrowing was successful; false if book not found or out of
	 *         stock.
	 */
	public boolean borrowBook(Scanner scanner) {
		if (numBooks == 0) {
			System.out.println("\nError...could not borrow book\n");
			return false;
		}
		System.out.print("\nEnter the code for the book: ");
		if (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.println("\nError...could not borrow book\n");
			return false;
		}
		int code = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < numBooks; i++) {
			if (catalog[i].bookCode == code) {
				System.out.print("Enter valid quantity to borrow: ");
				if (!scanner.hasNextInt()) {
					scanner.nextLine();
					System.out.println("Invalid quantity.");
					return false;
				}
				int quantity = scanner.nextInt();
				scanner.nextLine();
				if (quantity <= 0 || quantity > catalog[i].quantityInStock) {
					System.out.println("Invalid quantity.");
					return false;
				}
				catalog[i].updateQuantity(-quantity);
				return true;
			}
		}
		System.out.println("Error...book not in the catalog.");
		return false;
	}

	/**
	 * returnBook
	 * 
	 * @param scanner Scanner to read the book code from the user.
	 * @return true if the return was successful; false if book not found.
	 */
	public boolean returnBook(Scanner scanner) {
		if (numBooks == 0) {
			System.out.println("\nError...could not return book\n");
			return false;
		}

		System.out.print("\nEnter the code for the book: ");
		if (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.println("\nError...could not return book\n");
			return false;
		}
		int code = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < numBooks; i++) {
			if (catalog[i].bookCode == code) {
				System.out.print("Enter valid quantity to return: ");
				if (!scanner.hasNextInt()) {
					scanner.nextLine();
					System.out.println("Invalid quantity.");
					return false;
				}
				int quantityToReturn = scanner.nextInt();
				scanner.nextLine();

				if (quantityToReturn <= 0) {
					System.out.println("Invalid quantity.");
					return false;
				}

				// Determine how many were borrowed
				int borrowedSoFar = catalog[i].totalQuantity - catalog[i].quantityInStock;

				if (quantityToReturn > borrowedSoFar) {
					System.out.println("Error...Trying to return more than checkout quantity");
					return false;
				}

				catalog[i].updateQuantity(quantityToReturn);
				return true;
			}
		}

		System.out.println("Error...book not in the catalog.");
		return false;
	}

}
