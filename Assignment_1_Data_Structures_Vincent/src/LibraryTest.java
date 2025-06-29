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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

// This is using JUnit 4 buildpath

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBookSuccessfully() {
        // Simulate user input for adding a Fiction book
        String input = "f\n123\nTest Book\nAuthor\n10\n";
        Scanner scanner = new Scanner(input);

        boolean added = library.addBook(scanner);

        assertTrue("Book should be added successfully", added);
        assertEquals("Library should have one book", 1, library.toString().split("\n").length - 1);

        scanner.close();
    }

    @Test
    public void testAddDuplicateBook() {
        String input = "f\n123\nDuplicate\nAuthor\n10\n" +
                        "f\n123\nDuplicate\nAuthor\n10\n";
        Scanner scanner = new Scanner(input);

        assertTrue(library.addBook(scanner));
        assertFalse("Adding duplicate book should fail", library.addBook(scanner));

        scanner.close();
    }

    @Test
    public void testBorrowBookSuccessfully() {
        String inputAdd = "f\n123\nBorrowMe\nAuthor\n10\n";
        Scanner scannerAdd = new Scanner(inputAdd);
        library.addBook(scannerAdd);
        scannerAdd.close();

        String inputBorrow = "123\n2\n";
        Scanner scannerBorrow = new Scanner(inputBorrow);

        assertTrue("Borrowing 2 books should succeed", library.borrowBook(scannerBorrow));

        scannerBorrow.close();
    }

    @Test
    public void testBorrowBookInvalidCode() {
        String input = "999\n";
        Scanner scanner = new Scanner(input);

        assertFalse("Borrowing non-existent book should fail", library.borrowBook(scanner));

        scanner.close();
    }

    @Test
    public void testReturnBookSuccessfully() {
        String inputAdd = "f\n123\nReturnMe\nAuthor\n10\n";
        Scanner scannerAdd = new Scanner(inputAdd);
        library.addBook(scannerAdd);
        scannerAdd.close();

        String inputBorrow = "123\n2\n";
        Scanner scannerBorrow = new Scanner(inputBorrow);
        library.borrowBook(scannerBorrow);
        scannerBorrow.close();

        String inputReturn = "123\n2\n";
        Scanner scannerReturn = new Scanner(inputReturn);

        assertTrue("Returning borrowed book should succeed", library.returnBook(scannerReturn));

        scannerReturn.close();
    }

    @Test
    public void testReturnBookMoreThanBorrowed() {
        String inputAdd = "f\n123\nTooMuch\nAuthor\n10\n";
        Scanner scannerAdd = new Scanner(inputAdd);
        library.addBook(scannerAdd);
        scannerAdd.close();

        String inputBorrow = "123\n2\n";
        Scanner scannerBorrow = new Scanner(inputBorrow);
        library.borrowBook(scannerBorrow);
        scannerBorrow.close();

        // Trying to return more than borrowed
        String inputReturn = "123\n5\n";
        Scanner scannerReturn = new Scanner(inputReturn);

        assertFalse("Returning more than borrowed should fail", library.returnBook(scannerReturn));

        scannerReturn.close();
    }
}