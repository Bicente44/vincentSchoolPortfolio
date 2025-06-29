
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Manages a collection of Book objects, allowing addition, borrowing,
 * returning, searching, and persistence (save/load) via the console.
 * 
 * @author Vincent Welbourne
 * 
 */
public class Library {

	/**
	 * An ArrayList of book objects, sorted by bookCode
	 */
	private ArrayList<Book> catalog;

	/**
	 * numBooks a variable that contains the current number of books
	 */
	private int numBooks;

	/**
	 * Library -- Default constructor, constructs and empty library
	 */
	public Library() {
		catalog = new ArrayList<>();
	}

	/**
	 * Checks whether a given book already exists in the catalog using isEqual().
	 * 
	 * @param book The book to check against the existing catalog.
	 * @return the index of the existing book in catalog, or -1 if not found
	 */
	public int alreadyExists(Book book) {
		int i = 0;
		for (Book newBook : catalog) {
			if (book.isEqual(newBook)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Adds a new book to the library based on user input. The user selects the type
	 * of book, enters its code, and provides book details.
	 * 
	 * @param scanner  Scanner for reading console input
	 * @param fromFile
	 * @return true if the book is added successfully; false otherwise.
	 */
	public boolean addBook(Scanner scanner, boolean fromFile) {
		System.out.print("Do you wish to add a Fiction(f), Non-Fiction(n), or Reference(r) book? ");
		String input = scanner.nextLine().trim().toLowerCase();
		Book newBook;
		// Fiction, Nonfiction and reference options
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
		if (!newBook.addBook(scanner, fromFile)) {
			System.out.println("Failed to add book.");
			return false;
		}

		// Check if book already exists
		int existingIndex = alreadyExists(newBook);
		if (existingIndex != -1) {
			// existingIndex >= 0 means we found the same code
			System.out.println("Book already exists in the catalog.");
			return false;
		}

		int insertPos = 0;
		while (insertPos < catalog.size() && catalog.get(insertPos).bookCode < newBook.bookCode) {
			insertPos++;
		}
		catalog.add(insertPos, newBook);
		numBooks++;

		return true;
	}

	/**
	 * 
	 * Attempts to borrow one or more copies of a book. Prompts for the bookCode
	 * then for the quantity, validating both and preventing reference books from
	 * being borrowed.
	 * 
	 * @param scanner Scanner for reading console input
	 * @return true if borrowing was successful; false if book not found or out of
	 *         stock.
	 * 
	 */
	public boolean borrowBook(Scanner scanner) {
		Book chosenBook = null;

		if (numBooks == 0) {
			System.out.println("\nError...could not borrow book\n");
			return false;
		}

		int code = -1;
		while (true) {
			System.out.print("\nEnter the code for the book: ");
			try {
				code = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Invalid code. Please enter a valid number");
			}
		}

		// Search for the book in catalog
		for (int i = 0; i < numBooks; i++) {
			if (catalog.get(i).bookCode == code) {
				chosenBook = catalog.get(i);
				break;
			}
		}
		// If not found
		if (chosenBook == null) {
			System.out.println("Book not found.");
			return false;
		}

		// Check for reference books
		if (chosenBook instanceof ReferenceBook) {
			System.out.println("You cannot borrow a reference book.");
			return false;
		}

		int quantity = 0;
		while (true) {
			System.out.println("Enter the amount of books desired to borrow:\n");
			try {
				quantity = scanner.nextInt();
				scanner.nextLine();
				if (quantity <= 0) {
					System.out.println("Quantity must be greater than 0.");
					continue;
				}
				break;
			} catch (Exception e) {
				scanner.nextLine(); // clear invalid input
				System.out.println("Invalid quantity. Please enter a number.");
			}
		}
		// Try to update book quantity
		if (!chosenBook.updateQuantity(-quantity)) {
			System.out.println("You cannot borrow a book, trying to borrow more than you have");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Attempts to return one or more copies of a book. Prompts for the bookCode
	 * then for the quantity, validating both and preventing returning more copies
	 * than were borrowed.
	 * 
	 * @param scanner Scanner for reading console input
	 * @return true if the return succeeded otherwise
	 */
	public boolean returnBook(Scanner scanner) {
		Book chosenBook = null;
		int code = -1;
		int quantityToReturn = -1;
		// check if catalog empty
		if (numBooks == 0) {
			System.out.println("\nError...could not return book\n");
			return false;
		}
		// Code validation
		while (true) {
			System.out.print("\nEnter the code for the book: ");
			try {
				code = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Invalid code. Please enter a valid numeric book code.");
			}
		}
		// Find book chosen
		for (int i = 0; i < numBooks; i++) {
			if (catalog.get(i).bookCode == code) {
				chosenBook = catalog.get(i);
				break;
			}
		}
		if (chosenBook == null) { // if not found
			System.out.println("Book not found.");
			return false;
		}
		while (true) {
			System.out.print("Enter valid quantity to return: ");
			try {
				quantityToReturn = scanner.nextInt();
				scanner.nextLine();
				if (quantityToReturn <= 0) {
					System.out.println("Quantity must be greater than 0.");
					continue;
				}
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Invalid quantity. Please enter a number.");
			}
		}

		// Determine how many were borrowed
		int borrowed = (chosenBook.totalQuantity - chosenBook.quantityInStock);
		// Check if trying to take more then have
		if (quantityToReturn > borrowed) {
			System.out.println("Error...Trying to return more than checkout quantity");
			return false;
		}
		// Update quantity and return success
		chosenBook.updateQuantity(quantityToReturn);
		return true;
	}

	/**
	 * 
	 * Prompts for a bookCode and searches the catalog via binary search. Prints the
	 * book’s details if found, error message otherwise.
	 * 
	 * @param scanner Scanner for reading console input
	 */
	public void searchForBook(Scanner scanner) {
		int code;
		if (catalog.isEmpty()) {
			System.out.println("No book found in catalog!");
			return;
		}

		System.out.print("Enter the code of the book: ");
		try {
			code = scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			System.out.println("Invalid entry. Please enter a numeric book code.");
			return;
		}
		scanner.nextLine();

		int low = 0, high = catalog.size() - 1, foundIndex = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int midCode = catalog.get(mid).bookCode;

			if (midCode == code) {
				foundIndex = mid;
				break;
			} else if (midCode < code) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// Report result
		if (foundIndex == -1) {
			System.out.println("Code not found in catalog...");
		} else {
			System.out.println(catalog.get(foundIndex));
		}
	}

	/**
	 * Saves the current catalog to a file. Prompts the user for the filename and
	 * then writes each Book via its own {@code outputBook(Formatter)}.
	 *
	 * @param scanner Scanner for reading console input
	 */
	public void saveToFile(Scanner scanner) {
		System.out.print("Enter the filename to save to: ");
		String filename = scanner.next();

		try (Formatter writer = new Formatter(filename)) {
			for (Book book : catalog) {
				book.outputBook(writer);
			}
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	/**
	 * Reads books from a file and adds them to the catalog. Prompts the user for
	 * the filename. Expects blocks of lines matching each Book type and aborts on
	 * error.
	 *
	 * @param scanner Scanner for reading console input
	 */
	public void readFromFile(Scanner scanner) {
		System.out.print("Enter the filename to read from: ");
		String fileName = scanner.next().trim();
		Book newBook = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String type = line.trim().toLowerCase(); // "f", "n", or "r"

				// Read the shared fields
				int bookCode = Integer.parseInt(reader.readLine().trim());
				String title = reader.readLine();
				int quantity = Integer.parseInt(reader.readLine().trim());
				String author = reader.readLine();

				// Instantiate and read the extra field & set genre
				if (type.equals("f")) {
					newBook = new FictionBook();
					newBook.genre = "Fiction";

				} else if (type.equals("n")) {
					String fieldOfStudy = reader.readLine();
					NonFictionBook nfb = new NonFictionBook();
					nfb.fieldOfStudy = fieldOfStudy;
					nfb.genre = "NonFiction";
					newBook = nfb;

				} else if (type.equals("r")) {
					String edition = reader.readLine();
					ReferenceBook rb = new ReferenceBook();
					rb.edition = edition;
					rb.genre = "Reference";
					newBook = rb;

				} else {
					// Unknown type, skip
					continue;
				}

				// Populate the rest
				newBook.bookCode = bookCode;
				newBook.title = title;
				newBook.quantityInStock = quantity;
				newBook.totalQuantity = quantity;
				newBook.author = author;

				// Duplicate check: abort on first duplicate
				if (alreadyExists(newBook) != -1) {
					System.out.println("Book code already exists");
					throw new IOException("duplicate");
				}

				// Insert in sorted order
				int insertPos = 0;
				while (insertPos < catalog.size() && catalog.get(insertPos).bookCode < bookCode) {
					insertPos++;
				}
				catalog.add(insertPos, newBook);
				numBooks++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error Encountered while reading the file, aborting..");
		}
	}

	/**
	 * Returns a String representation of the entire library catalog. Each book
	 * appears on its own line via its {@code toString()}.
	 *
	 * @return a human readable listing of all books in the catalog
	 */
	@Override
	public String toString() {
		String output = "Library:\n";
		for (Book book : catalog) {
			output += book.toString() + "\n";
		}
		return output;
	}
}
