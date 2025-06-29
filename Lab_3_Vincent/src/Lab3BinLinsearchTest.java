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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This driver class acts as the menu that gets displayed to the user and takes
 * the option and gets the information from the BinaryLinearSearch class.
 * 
 * The class provides options to the user and asks for the Search Key (a char)
 * to send over to the BinaryLinearSearch.java file to find that specific
 * character in the array initialized by a Secure Randomizer.
 * 
 * @author Vincent Welbourne
 * 
 */
public class Lab3BinLinsearchTest {

	/**
	 * Main method that serves as the user interface for the program. It initializes
	 * the menu and handles user input.
	 * 
	 * @param args no arguments
	 */
	public static void main(String[] args) {

		// Declarations
		Scanner keyboard = new Scanner(System.in);
		boolean LOOP = true;
		BinaryLinearSearch binLinSearch = new BinaryLinearSearch();
		char skey;

		do {
			System.out.printf("\nSelect your option in the menu:\n"
					+ "1. Initialize and populate an array of 32 random characters.\n"
					+ "2. Perform recursive binary and linear search.\n"
					+ "3. Perform iterative binary and linear search.\n" + "4. Exit.\n");
			try {
				int option = keyboard.nextInt();
				switch (option) {
//		1. Initialize and populate an array of 32 random characters.
				case 1:
					binLinSearch.generateRandomChars();
					break;
//		2. Perform recursive binary and linear search.
				case 2:
					// Ask user for a character to search
					System.out.print("\nPlease enter a character to search: ");
					String recursiveInput = keyboard.next();
					skey = recursiveInput.charAt(0);

					// Output array during recursive binary search
					System.out.println("\nRemaining elements during Recursive Binary Search:");

					long startRecBin = System.nanoTime(); // Start time
					binLinSearch.recursiveBinarySearch(skey); // Call binary search
					long endRecBin = System.nanoTime(); // End time
					long durationRecBin = endRecBin - startRecBin;

					// Print time in nano and milliseconds
					System.out.printf("\nTime taken in nanoseconds: %d\n", durationRecBin);
					System.out.printf("Time taken in milliseconds: %d\n\n", durationRecBin / 1_000_000);

					// Output array slice before recursive linear search
					System.out.println("Remaining elements during Recursive Linear Search:");

					long startRecLin = System.nanoTime(); // Start time
					binLinSearch.recursiveLinearSearch(skey); // Call linear search
					long endRecLin = System.nanoTime(); // End time
					long durationRecLin = endRecLin - startRecLin;

					// Print time in nano and milliseconds
					System.out.printf("\nTime taken in nanoseconds: %d\n", durationRecLin);
					System.out.printf("Time taken in milliseconds: %d\n", durationRecLin / 1_000_000);
					break;
//		3. Perform iterative binary and linear search.
				case 3:
					// Ask user for character
					System.out.print("\nPlease enter a character to search: ");
					String iterativeInput = keyboard.next();
					skey = iterativeInput.charAt(0);

					// Iterative Binary Search
					long startBinary = System.nanoTime();
					binLinSearch.iterativeBinarySearch(skey);
					long endBinary = System.nanoTime();
					long durationBinary = endBinary - startBinary;

					System.out.printf("\nTime taken in nanoseconds: %d\n", durationBinary);
					System.out.printf("Time taken in milliseconds: %d\n\n", durationBinary / 1_000_000);

					// Iterative Linear Search
					long startLinear = System.nanoTime();
					binLinSearch.iterativeLinearSearch(skey);
					long endLinear = System.nanoTime();
					long durationLinear = endLinear - startLinear;

					System.out.printf("\nTime taken in nanoseconds: %d\n", durationLinear);
					System.out.printf("Time taken in milliseconds: %d\n", durationLinear / 1_000_000);
					break;
//		4. Exit.
				case 4:
					LOOP = false;
					break;
				default:
					System.out.println("Please choose a valid option (1 to 4).");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("***** Input Mismatch Exception *****");
				keyboard.nextLine();
			}
		} while (LOOP);
		System.out.println("Exiting program...");
		keyboard.close();
	}
}