
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
 * Assignment 2
 * 
 */

import java.util.Scanner;

/**
 * This class contains the main program loop for managing a library system. It
 * allows the user to add books, display the catalog, borrow and return books.
 * 
 * @author Vincent Welbourne
 * 
 */
public class Assign2 {
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
			System.out.print("\nPlease select one of the following:\n" + "1: Add Book to Library\n"
					+ "2: Display Current Library Catalog\n" + "3: Borrow Book(s)\n" + "4: Return Book(s)\n"
					+ "5: Search for Book\n" + "6: Save Library Catalog to File\n"
					+ "7: Read Library Catalog from File\n" + "8: Exit.\n");
			System.out.print(">");

			if (!scanner.hasNextInt()) {
				scanner.nextLine(); // Consume invalid input, do NOT reuse variable name scanner
				System.out.println("\n...Invalid input. Please enter a valid number...\n");
				continue;
			}

			choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
//			Add book
			case 1:
				boolean added = library.addBook(scanner, false);
				if (!added) {
					// Failed to add (duplicate code, invalid input, etc.)
				}
				break;
//				Add book
			case 2:
				System.out.println(library.toString());
				break;
//				Borrow book
			case 3:
				library.borrowBook(scanner);
				break;
//				Return book
			case 4:
				library.returnBook(scanner);
				break;
//				Search book
			case 5:
				library.searchForBook(scanner);

				break;
//				Save book
			case 6:
				library.saveToFile(scanner);
				break;
//				Read book
			case 7:
				library.readFromFile(scanner);
				break;
//				Exit Program
			case 8:
				System.out.println("\n...Exiting...Program by Vincent Welbourne");
				scanner.close(); // Avoid memory leak
				return;
			default:
				System.out.println("...Invalid option. Please pick a number between (1 - 8)\n");
			}
		}
	}
}
