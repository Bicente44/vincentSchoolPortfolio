/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class manages the NFL games. It loads game data from a CSV file and displays the scheduled games
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Game> games;  // Collection to store Game objects

    // Constructor initializes the games list.
    public GameManager() {
        games = new ArrayList<>();
    }

    /**
     * Loads games from a CSV file.
     * Expected CSV format per line: team1,team2,date,location,score
     *
     * @param filename The path to the games.csv file.
     */
    public void loadGames(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                String team1 = parts[0].trim();
                String team2 = parts[1].trim();
                String date = parts[2].trim();
                String location = parts[3].trim();
                String score = parts[4].trim();

                Game game = new Game(team1, team2, date, location, score);
                games.add(game);
            }
        } catch (IOException e) {
            System.out.println("Error reading games file: " + e.getMessage());
        }
    }

    /**
     * Displays all scheduled games in a formatted table.
     */
    public void displayGames() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-12s %-20s %-10s%n", "Home", "Visitor", "Date", "Location", "Score");
        System.out.println("-------------------------------------------------------------------");
        for (Game game : games) {
            System.out.println(game.toString());
        }
    }
}
