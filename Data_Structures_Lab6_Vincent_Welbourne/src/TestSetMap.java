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

// Imports
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Driver class that runs the SetMapLib menu loop.
 * Displays options, reads user input for SetMapLib.
 * @author Vincent Welbourne
 */
public class TestSetMap {
	
	/**
	 * main method
	 * 
	 * @param args unused commandline arguments
	 */
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		int key = 0;
		SetMapLib setmaplib = new SetMapLib();

		while (true) {
			System.out.print("\nPlease select one of the following:\n" 
					+ "1: Create a TreeMap of data from the text file\n"
					+ "2: Display the TreeMap\n" 
					+ "3: Search for a given key or value in the TreeMap\n" 
					+ "4: Create and display a keys TreeSet and a values TreeSet from the TreeMap\n"
					+ "5: Sort and display values TreeSet in descending order\n" 
					+ "6: Add new key-value data to the TreeMap\n" 
					+ "7: Exit.\n"
					+ ">");

			try {
				choice = keyboard.nextInt(); // Get user input
			
			keyboard.nextLine(); // Consume newline
			
			switch (choice) {
//			Create a TreeMap of data from the text file
			case 1:
				setmaplib.createTreeMap();
				break;
//				Display the TreeMap
			case 2:
				setmaplib.displayTreeMap();
				break;
//				Search for a given key or value in the TreeMap
			case 3:
				
				System.out.print("Enter a 4 digit number key\n>"); // TODO: Why is it making 2 input prompts
				key = keyboard.nextInt(); // Allow user to input the key
				keyboard.nextLine();
				
				setmaplib.searchTreeMapKey(key);
				break;
//				Create and display a keys TreeSet and a values TreeSet from the TreeMap
			case 4:
				setmaplib.createTreeSet();
				break;
//				Sort and display values TreeSet in descending order
			case 5:
				setmaplib.sortTreeSet();
				break;
//				Add new key-value data to the TreeMap
			case 6:
				String value;
				
				System.out.print("Enter a 4 digit number key\n>");
				key = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.print("Enter value data\n>");
				value = keyboard.next();
				
				setmaplib.addToTreeMap(value, key);
				break;
//				Exit Program
			case 7:
				System.out.println("Exiting Program by Vincent Welbourne");
				keyboard.close();
				return;
			default:
				System.out.println("Invalid number. options are (1 - 7)\n");
			}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number");
				keyboard.nextLine();
			}
		}
	}
}

