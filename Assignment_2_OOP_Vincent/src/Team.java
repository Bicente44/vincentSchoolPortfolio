/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class represents an NFL team. It implements Serializable and contains the team's name, city, Coach object,
 * and a list of Player objects. It provides methods to add a player and retrieve players.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    private String teamName;
    private String city;
    private Coach coach;
    private List<Player> players; // List to hold Player objects

    // Parameterized constructor to initialize team attributes
    public Team(String teamName, String city, Coach coach) {
        this.teamName = teamName;
        this.city = city;
        this.coach = coach;
        this.players = new ArrayList<>();
    }

    // Method to add a player to the team (as per assignment instructions)
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Returns the list of players
    public List<Player> getPlayers() {
        return players;
    }

    // Getter for teamName (used when searching teams)
    public String getTeamName() {
        return teamName;
    }

    // Returns a formatted string for displaying team information
    @Override
    public String toString() {
        // Format: TeamName, City, Coach details, and number of players
        return String.format("%-10s %-15s %-30s %d", teamName, city, coach.toString(), players.size());
    }
}

	/*TODO:
	 * Methods
	 *You will implement methods to:
	 *Add a player to the team (addPlayer(Player player))
	 *Return the list of players (getPlayers())
	 *You will need to override the toString() method to return a formatted string.
	 */
	

