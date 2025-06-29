/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description:  This class represents a scheduled NFL game. It implements Serializable and stores information
 * about the two teams, the game date, location, and score.
 */

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L; // Unique ID for serialization compatibility

    // Attributes as specified in the assignment instructions
    private String team1;
    private String team2;
    private String date;
    private String location;
    private String score;

    // Parameterized constructor to initialize all game attributes
    public Game(String team1, String team2, String date, String location, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
        this.score = score;
    }

    // Overridden toString() method for formatted output
    @Override
    public String toString() {
        return String.format("%-10s %-10s %-12s %-20s %-10s", team1, team2, date, location, score);
    }
}
