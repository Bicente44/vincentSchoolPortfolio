/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This class manages the NFL teams. It loads team data from a CSV file, displays teams,
 * adds new teams, and provides a method to search for teams by name.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private List<Team> teams;

    // Constructor initializes the teams list.
    public TeamManager() {
        teams = new ArrayList<>();
    }

    /**
     * Loads teams from a CSV file.
     * Expected CSV format per line: teamName,city,coachName,coachYearsOfExperience
     * If the line is invalid, it is skipped.
     *
     * @param filename The path to the teams.csv file.
     */
    public void loadTeams(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                String teamName = parts[0].trim();
                String city = parts[1].trim();
                String coachName = parts[2].trim();
                int yearsOfExperience = 0;
                try {
                    yearsOfExperience = Integer.parseInt(parts[3].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number for coach years in line: " + "Starting over");
                    
                }
                Coach coach = new Coach(coachName, yearsOfExperience);
                Team team = new Team(teamName, city, coach);
                teams.add(team);
            }
        } catch (IOException e) {
            System.out.println("Error reading teams file: " + e.getMessage());
        }
    }

    /**
     * Displays the list of teams with a formatted header.
     */
    public void displayTeams() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-30s %-5s%n", "Team", "City", "Coach", "Players");
        System.out.println("-------------------------------------------------------------------");
        for (Team team : teams) {
            System.out.println(team.toString());
        }
    }

    /**
     * Adds a new team to the list.
     *
     * @param team The Team object to add.
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * Finds a team by name (ignoring case).
     *
     * @param teamName The team name to search for.
     * @return The Team if found; otherwise, null.
     */
    public Team findTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Returns the list of teams.
     *
     * @return List of Team objects.
     */
    public List<Team> getTeams() {
        return teams;
    }
}
