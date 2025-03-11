import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerQueue players = new PlayerQueue(50); // Initializes the  queue with a maximum capacity of 50
        Random rand = new Random();  // Declare Random object for generating random values
        Scanner scanner = new Scanner(System.in); // // Declare Scanner object for user input
        int gamesPlayed = 0; // Declare Game counter to track the number of games played

        while (gamesPlayed < 10) { // Loops until 10 games have been played
            int newPlayers = rand.nextInt(7) + 1;  // Generate a random number from 1-7 players

            // Enqueue the new players
            for (int i = 0; i < newPlayers; i++) {
                int id = rand.nextInt(1000);
                players.enqueue(new Player(id, "Player " + id, rand.nextInt(500) + 1));
            }

            // Displays the current queue of players
            System.out.println("\n\nCurrent Queue: ");
            players.printQueue();
            System.out.println("\n\nPress Enter to continue.");
            scanner.nextLine();

            // Checks if there are at least 5 players in the queue before starting the game
            if (players.getSize() >= 5) {
                System.out.println("\nStarting a game with the following players:");

                // Dequeue 5 players for the next game
                for (int i = 0; i < 5; i++) {
                    Player dequeuedPlayer = players.dequeue();
                    if (dequeuedPlayer != null) {
                        System.out.println(dequeuedPlayer);
                    }
                }
                gamesPlayed++; // Increments the game counter
                System.out.println("\nGame " + gamesPlayed + " has started."); // Displays current game number
            }
        }
        // Display complete game message once 10 games have been played
        System.out.println("\n\n10 games has been completed. Thank You for Playing.");
        scanner.close(); // Closes the program
    }
}
