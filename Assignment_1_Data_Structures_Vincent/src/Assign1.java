
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
 * This class contains the main program loop for managing a library system.
 * It allows the user to add books, display the catalog, borrow and return books.
 * 
 * @author Vincent Welbourne
 * 
 */
public class Assign1 {
	/**
	 * main
	 * 
	 * @param args unused commandline arguments
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		int choice = 0;

		while (true) {
			System.out.print("\nPlease select one of the following:\n" + "1. Add Book to Library\n"
					+ "2. Display Current Library Catalog\n" + "3. Borrow Book(s)\n" + "4. Return Book(s)\n"
					+ "5. Exit.\n");
			System.out.print(">");

			if (!scanner.hasNextInt()) {
				scanner.nextLine(); // Consume invalid input, do NOT reuse variable name scanner
				System.out.println("\n...Invalid input. Please enter a valid number...\n");
				continue;
			}

			choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				if (!library.addBook(scanner)) {
					// If the user failed to add a book, keep trying
					continue;
				}
				break;
			case 2:
				System.out.println(library.toString());
				break;
			case 3:
				library.borrowBook(scanner);
				break;
			case 4:
				library.returnBook(scanner);
				break;
			case 5:
				System.out.println("\nExiting...<Program by VW>");
				scanner.close();
				return;
			default:
				System.out.println("\n...Invalid option. Please try again...\n");
			}
		}
	}
}
