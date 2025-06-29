/* Student: Vincent Welbourne
 * Student ID: 041161454
 * Professor: Howard Rosenblum
 * Program: CST8132 - Object Oriented Programming
 * Section: 323
 * Assessment: Assignment 02
 * Description: This is the driver class that contains the main() method. It displays a menu-driven console interface for managing
 * NFL teams, players, and scheduled games by using the TeamManager, PlayerManager, and GameManager classes.
 */

import java.util.Scanner;

public class NFLManagementSystem {
    public static void main(String[] args) {
        // Explanation of Serializable and serialVersionUID
        System.out.println("Note: The Serializable interface allows object state to be saved and restored."
        				+"\nThe serialVersionUID is a unique ID that helps ensure compatibility when deserializing objects.");

        // Instantiate managers
        TeamManager teamManager = new TeamManager();
        PlayerManager playerManager = new PlayerManager(teamManager);
        GameManager gameManager = new GameManager();

        // Load data from CSV files
        teamManager.loadTeams("teams.csv");
        playerManager.loadPlayers("players.csv");
        gameManager.loadGames("games.csv");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("*** Invalid input! Please enter a number from 1 to 7. ***");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    teamManager.displayTeams();
                    break;
                case 2:
                    playerManager.displayPlayers();
                    break;
                case 3:
                    gameManager.displayGames();
                    break;
                case 4:
                    addNewTeam(scanner, teamManager);
                    break;
                case 5:
                    addNewPlayer(scanner, playerManager, teamManager);
                    break;
                case 6:
                    findTeam(scanner, teamManager);
                    break;
                case 7:
                    System.out.println("\n*****************************************************");
                    System.out.println(" ...Exiting the program by Vincent Welbourne...");
                    System.out.println("*****************************************************");
                    break;
                default:
                    System.out.println("*** Invalid choice. Please try again. ***");
            }
        } while (choice != 7);

        scanner.close();
    }

    /**
     * Displays the main menu.
     */
    private static void showMenu() {
        System.out.println("\nNFL Operations Management System");
        System.out.println("1. Display Teams");
        System.out.println("2. Display Players");
        System.out.println("3. Display Scheduled Games");
        System.out.println("4. Add Team");
        System.out.println("5. Add Player to Team");
        System.out.println("6. Find Team");
        System.out.println("7. Exit");
    }

    /**
     * Prompts the user to add a new team and adds it via the TeamManager.
     *
     * @param scanner     The Scanner for user input.
     * @param teamManager The TeamManager to add the team to.
     */
    private static void addNewTeam(Scanner scanner, TeamManager teamManager) {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter coach name: ");
        String coachName = scanner.nextLine();

        int coachYears = 0;
        try {
            System.out.print("Enter coach years of experience: ");
            coachYears = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("*** Invalid input for years of experience. Using 0. ***");
        }

        Coach newCoach = new Coach(coachName, coachYears);
        Team newTeam = new Team(teamName, city, newCoach);
        teamManager.addTeam(newTeam);
        System.out.println("Team added successfully!");
    }

    /**
     * Prompts the user to add a new player and adds it via the PlayerManager.
     *
     * @param scanner       The Scanner for user input.
     * @param playerManager The PlayerManager to add the player to.
     * @param teamManager   The TeamManager is used to link the player to a team.
     */
    private static void addNewPlayer(Scanner scanner, PlayerManager playerManager, TeamManager teamManager) {
        System.out.print("Enter player ID: ");
        String playerId = scanner.nextLine();
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        int playerAge = 0;
        try {
            System.out.print("Enter player age: ");
            playerAge = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("*** Invalid age input. Using age 0. ***");
        }

        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter player position: ");
        String position = scanner.nextLine();

        Player newPlayer = new Player(playerId, playerName, playerAge, teamName, position);
        playerManager.addPlayer(newPlayer);
        System.out.println("Player added successfully!");
    }

    /**
     * Searches for a team by name and displays its information.
     *
     * @param scanner     The Scanner for user input.
     * @param teamManager The TeamManager used to search for the team.
     */
    private static void findTeam(Scanner scanner, TeamManager teamManager) {
        System.out.print("Enter team name to search: ");
        String searchName = scanner.nextLine();
        Team foundTeam = teamManager.findTeam(searchName);
        if (foundTeam != null) {
            System.out.println("Team found: " + foundTeam.toString());
        } else {
            System.out.println("Team not found.");
        }
    }
}
