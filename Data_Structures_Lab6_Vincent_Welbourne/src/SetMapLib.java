
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Handles TreeMap and all TreeSets.
 * Allows creation of TreeMap and TreeSets, Displays to user and contains search.
 */
public class SetMapLib {
	// Declarations
	private TreeMap<Integer, String> treeMap = new TreeMap<>();
	private Set<String> treeSetKey5 = new TreeSet<>();
	private Set<String> treeSetVal5 = new TreeSet<>();
	private Set<String> treeSetKey8 = new TreeSet<>();
	private Set<String> treeSetVal8 = new TreeSet<>();
	private Set<String> descendingTreeSet = new TreeSet<>(new descendingComparator());

	class descendingComparator implements Comparator<String> {
		public int compare(String str1, String str2) {
			return str2.compareTo(str1); // compare using compareTo() method
		}
	}

	/**
	 * Create Tree Map from file, populates TreeMap. Also creates an original
	 * TreeSet copy for task 5/8.
	 */
	public void createTreeMap() {

		String filename = "C:\\Users\\vince\\eclipse-workspace\\Data_Structures_Lab6_Vincent_Welbourne\\src\\customers.txt";
		Path file = Paths.get(filename);

		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			String fields[];

			while ((line = input.readLine()) != null) {
				fields = line.split(",");
				treeMap.put(Integer.parseInt(fields[1].trim()), fields[0]);
			}
			System.out.println("...TreeMap Created...");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		for (Map.Entry<Integer, String> e : treeMap.entrySet()) { // Iterate through TreeMap
			int mKey = e.getKey(); // getting the key for TreeSet
			String mValue5 = e.getValue(); // getting the value to insert into TreeSet
			String setKey5 = Integer.toString(mKey); // Parse Integer into a String

			treeSetKey5.add(setKey5); // Adding Keys to TreeSet
			treeSetVal5.add(mValue5); // Adding values to TreeSet
		}
	}

	/**
	 * Prints contents of TreeMap. If TreeMap is empty notifies user.
	 */
	public void displayTreeMap() {
		if (!treeMap.isEmpty()) {
			System.out.println("Printed TreeMap");
			System.out.println(treeMap);
		} else {
			System.out.println("TreeMap not created");
		}

	}

	/**
	 * Searches the TreeMap for a given integer key.
	 * 
	 * @param key used to compare and find the key in the file
	 * @return true if the key was found else, false
	 */
	public Boolean searchTreeMapKey(int key) {
		for (Map.Entry<Integer, String> e : treeMap.entrySet()) { // Iterate through TreeMap
			int fKey = e.getKey(); // File Key
			if (key == fKey) { // Compare if the keys are the same
				System.out.println("Key: '" + key + "' was found.");
				return true;
			}
		}
		System.out.println("Key: '" + key + "' not found.");
		return false;
	}

	/**
	 * Create and display key and values of TreeSet from TreeMap. Displays 4
	 * TreeSets 1 key and val for the original, and 1 key an val for modified.
	 * 
	 */
	public void createTreeSet() {
		if (treeMap.isEmpty()) {
			System.out.println("Create TreeMap first");
			return;
		}
		for (Map.Entry<Integer, String> e : treeMap.entrySet()) { // Iterate through TreeMap
			int mKey = e.getKey(); // getting the key for TreeSet
			String mValue = e.getValue(); // getting the value to insert into TreeSet
			String setKey = Integer.toString(mKey); // Parse Integer into a String

			treeSetKey8.add(setKey); // Adding Keys to TreeSet
			treeSetVal8.add(mValue); // Adding values to TreeSet
		}
		// Print all TreeSets in ascending order
		System.out.println("Original TreeSet (No insertions just from file)\n");
		System.out.println("Keys TreeSet is [keys in ascending order]");
		System.out.println(treeSetKey5 + "\n");
		System.out.println("Names TreeSet  is [values in ascending order]");
		System.out.println(treeSetVal5 + "\n\n");

		System.out.println("Full TreeSet (With insertions and changes)\n");
		System.out.println("Keys TreeSet is [keys in ascending order]");
		System.out.println(treeSetKey8 + "\n");
		System.out.println("Names TreeSet  is [values in ascending order]");
		System.out.println(treeSetVal8 + "\n\n");
		System.out.println("Explanation:\nTask 5 shows the map with file contents; Task 8 shows it  with all modifications.");

		return;
	}

	/**
	 * Sorts and displays the values TreeSet in descending order. Uses modified
	 * TreeSet.
	 */
	public void sortTreeSet() {
		descendingTreeSet.addAll(treeSetVal8);
		System.out.println("Descending Set (Modified Set): \n" + descendingTreeSet);
	}

	/**
	 * Adds a new key value pair to the TreeMap and displays the updated TreeMap
	 * 
	 * @param value the String value to insert
	 * @param key   the integer key to associate with the value
	 */
	public void addToTreeMap(String value, int key) {
		treeMap.put(key, value);
		System.out.println("New TreeMap");
		System.out.println(treeMap);
	}
}
