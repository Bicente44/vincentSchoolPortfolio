
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

import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;

/**
 * This class manages an array of random char's and provides multiple methods to showcase
 * different searches to filter an array and sends back to the Lab2BinLinSearchTest.java driver.
 * 
 * @author Vincent Welbourne
 * 
 */
public class BinaryLinearSearch {

	/**
	 * An array of random characters.
	 */
	char[] randChar;
	/**
	 * The search key (character to search for).
	 */
	char sKey;
	/**
	 * A Scanner object to accept user input.
	 */
	Scanner keyboard = new Scanner(System.in);
	/**
	 * A string of chars that are allowed to be used in the secure random array.
	 */
	String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	/**
	 * Initialize SecureRandom.
	 */
	SecureRandom random = new SecureRandom();
	/**
	 * This is the array once its been halved
	 */
	char[] halvedArray;

	/**
	 * 3. generateRandomChars
	 * 
	 * Uses the SecureRandom class to generate an array of random characters. The
	 * array will contain 32 randomly generated characters. The characters will be
	 * drawn from both uppercase and lowercase letters (A-Z and a-z). This method
	 * prints the sorted array of random characters on the screen. Note: Both binary
	 * search and linear search methods receive the same array of randomly generated
	 * characters. Linear search algorithm does not require the array to be sorted.
	 * Also make generateRandomInts display the unsorted random array with menu
	 * option 1. This means that when the user selects menu option 1, we should see
	 * two versions of the randomly generated array: the unsorted array and the
	 * sorted array.
	 * 
	 */
	public void generateRandomChars() {
		randChar = new char[32];
		boolean[] used = new boolean[chars.length()];

		int count = 0;
		while (count < 32) {
			int index = random.nextInt(chars.length());
			if (!used[index]) {
				randChar[count] = chars.charAt(index);
				used[index] = true;
				count++;
			}
		}
		System.out.printf("Unsorted array: %s\n", Arrays.toString(randChar));
		Arrays.sort(randChar);
		System.out.printf("Sorted array: %s\n", Arrays.toString(randChar));
	}

	/**
	 * 4. remainingElements.
	 * 
	 * This method displays elements remaining each time a half of the array is
	 * dropped.
	 */
	public void remainingElements() {
		System.out.printf("Unsorted array: %s\n", Arrays.toString(halvedArray));
	}
	/**
	 * 
	 * Integer variable for the lowest index
	 * 
	 */
	private int lowIndex = -1;
	/**
	 * 
	 * Integer variable for the highest index
	 * 
	 */
	private int highIndex = -1;

	/**
	 * 2. recursiveBinarySearch (uses recursion)
	 * 
	 * Receives an array of characters, the first index, the last index, and the
	 * search key. Recursively searches for the character in the array. If found, it
	 * returns the index and prints: Character ___ found at index ___: Recursive
	 * Binary Search. If not found, returns -1 and prints: Character ___ was not
	 * found.
	 * 
	 * @param sKey -- This is the Search Key passed from user to specify what to search for in the array
	 * 
	 */
	public void recursiveBinarySearch(char sKey) {
		this.sKey = sKey;

		// Check if the array is initialized
		if (randChar == null || randChar.length == 0) {
			System.out.println("Array is not initialized. Please generate characters first.");
			return;
		}
		// Initialize bounds only on the first call
		if (lowIndex == -1 && highIndex == -1) {
			lowIndex = 0;
			highIndex = randChar.length - 1;
		}
		// Base case search key not found
		if (lowIndex > highIndex) {
			System.out.printf("%c was not found: Recursive Binary Search\n", sKey);
			lowIndex = -1;
			highIndex = -1;
			return;
		}
		// Prints halved array to user
		halvedArray = Arrays.copyOfRange(randChar, lowIndex, highIndex + 1);
		remainingElements();

		int mid = lowIndex + (highIndex - lowIndex) / 2;
		// Found
		if (randChar[mid] == sKey) {
			System.out.printf("[%c]\n", sKey);
			System.out.printf("%c was found at index position %d: Recursive Binary Search", sKey, mid);
			lowIndex = -1;
			highIndex = -1;
		// Check if lower
		} else if (sKey < randChar[mid]) {
			highIndex = mid - 1;
			recursiveBinarySearch(sKey);
		// Else if higher
		} else {
			lowIndex = mid + 1;
			recursiveBinarySearch(sKey);
		}

	}


	private int linearIndex = -1;
	/**
	 * 6. recursiveLinearSearch (uses recursion)
	 * 
	 * Recursively searches for the character in the array. If found, returns the
	 * index and prints: Character ___ found at index ___: Recursive Linear Search.
	 * If not found, returns -1 and prints: Character ___ was not found.
	 * 
	 * @param sKey -- This is the Search Key passed from user to specify what to search for in the array
	 * 
	 */
	public void recursiveLinearSearch(char sKey) {
		if (linearIndex == -1) {
			System.out.println("Array: " + Arrays.toString(randChar));
		}

		this.sKey = sKey;

		// Check if array is initialized
		if (randChar == null || randChar.length == 0) {
			System.out.println("Array is not initialized. Please generate characters first.");
			return;
		}
		// Initialize index if this is the first call
		if (linearIndex == -1) {
			linearIndex = 0;
		}
		// Base case: not found
		if (linearIndex >= randChar.length) {
			System.out.printf("%c was not found: Recursive Linear Search\n", sKey);
			linearIndex = -1;
			return;
		}
		// Found case
		if (randChar[linearIndex] == sKey) {
			System.out.printf("[%c]\n", sKey);
			System.out.printf("%c was found at index position %d: Recursive Linear Search", sKey, linearIndex);
			linearIndex = -1;
			return;
		}
		// Recursive step
		linearIndex++;
		recursiveLinearSearch(sKey);
	}

	/**
	 * 1. iterativeBinarySearch(uses iterative/looping construct)
	 * 
	 * Receives an array of characters and the search key. If the character is
	 * present in the array, the method returns its index and prints: Character ___
	 * found at index ___: Iterative Binary Search. If the character is not found,
	 * the method returns -1 and prints: Character ___ was not found.
	 * 
	 * @param sKey -- This is the Search Key passed from user to specify what to search for in the array
	 * 
	 */
	public void iterativeBinarySearch(char sKey) {
		this.sKey = sKey;

		if (randChar == null || randChar.length == 0) {
			System.out.println("Array is not initialized. Please generate characters first.");
			return;
		}
		int low = 0;
		int high = randChar.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (randChar[mid] == sKey) {
				System.out.printf("%c was found at index position %d: Iterative Binary Search\n", sKey, mid);
				return;
			} else if (sKey < randChar[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// Character not found
		System.out.printf("%c was not found: Iterative Binary Search\n", sKey);
	}

	/**
	 * 5. iterativeLinearSearch (uses iterative/looping construct) Receives an array
	 * of characters and the search key. Iteratively searches for the character in
	 * the array. If found, returns the index and prints: Character ___ found at
	 * index ___: Iterative Linear Search. If not found, returns -1 and prints:
	 * Character ___ was not found.
	 * 
	 * @param sKey -- This is the Search Key passed from user to specify what to search for in the array
	 * 
	 */
	public void iterativeLinearSearch(char sKey) {
		this.sKey = sKey;

		// Check if the array is initialized
		if (randChar == null || randChar.length == 0) {
			System.out.println("Array is not initialized. Please generate characters first.");
			return;
		}
		// Loop through the array from start to end
		for (int i = 0; i < randChar.length; i++) {
			if (randChar[i] == sKey) {
				System.out.printf("%c was found at index position %d: Iterative Linear Search\n", sKey, i);
				return;
			}
		}
		// Character not found
		System.out.printf("%c was not found: Iterative Linear Search\n", sKey);
	}

}
