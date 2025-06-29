/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class represents an NFL coach. It implements Serializable and contains information about
 * the coach's name and years of experience.
 */

import java.io.Serializable;

public class Coach implements Serializable {
    private static final long serialVersionUID = 1L; // Unique ID for serialization compatibility

    // Attributes as per assignment instructions
    private String name;
    private int yearsOfExperience;

    // Parameterized constructor to initialize coach attributes
    public Coach(String name, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Overridden toString() method returns coach details in a formatted manner
    @Override
    public String toString() {
        return String.format("%s (%d years)", name, yearsOfExperience);
    }
}
