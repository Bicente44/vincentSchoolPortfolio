/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class manages NFL players. It loads player data from a CSV file, displays players,
 * and adds new players while associating them with the correct team using the TeamManager.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;       // Collection to store Player objects
    private TeamManager teamManager;    // Reference to the TeamManager to add players to teams

    // Constructor accepts a TeamManager instance so that players can be associated with teams.
    public PlayerManager(TeamManager teamManager) {
        players = new ArrayList<>();
        this.teamManager = teamManager;
    }

    /**
     * Loads players from a CSV file.
     * Expected CSV format per line: playerId,name,age,teamName,position
     *
     * @param filename The path to the players.csv file.
     */
    public void loadPlayers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                String playerId = parts[0].trim();
                String name = parts[1].trim();
                int age = 0;
                try {
                    age = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age for player " + name + " in line: " + line + ". Defaulting to 0.");
                }
                String teamName = parts[3].trim();
                String position = parts[4].trim();

                Player player = new Player(playerId, name, age, teamName, position);
                players.add(player);

                // Add the player to the corresponding team if the team exists.
                Team team = teamManager.findTeam(teamName);
                if (team != null) {
                    team.addPlayer(player);
                } else {
                    System.out.println("Team " + teamName + " not found for player " + name);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading players file: " + e.getMessage());
        }
    }

    /**
     * Displays all players in a formatted table.
     */
    public void displayPlayers() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-5s %-10s %-20s%n", "ID", "Player", "Age", "Team", "Position");
        System.out.println("-------------------------------------------------------------------");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

    /**
     * Adds a new player.
     * The player is added to the internal collection and, if applicable,
     * to the corresponding team via the TeamManager.
     *
     * @param player The new Player object to add.
     */
    public void addPlayer(Player player) {
        players.add(player);
        Team team = teamManager.findTeam(player.teamName);
        if (team != null) {
            team.addPlayer(player);
        } else {
            System.out.println("Team " + player.teamName + " not found. Player added without team association.");
        }
    }
}
