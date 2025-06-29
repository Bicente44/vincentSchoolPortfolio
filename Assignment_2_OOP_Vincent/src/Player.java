/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class represents an NFL player. It implements Serializable for object serialization,
 * and includes attributes such as player ID, name, age, team name, and position.
 */

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L; // Unique ID for serialization compatibility

    // Attributes as per assignment instructions
    String playerId;
    String name;
    int age;
    String teamName;
    String position;

    // Parameterized constructor to initialize all attributes
    public Player(String playerId, String name, int age, String teamName, String position) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
    }

    // Overridden toString() method for formatted output
    @Override
    public String toString() {
        return String.format("%-5s %-15s %-5d %-10s %-20s", playerId, name, age, teamName, position);
    }
}
