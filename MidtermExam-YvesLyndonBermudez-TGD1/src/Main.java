import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CardStack playerDeck = new CardStack(); // Creates CardStack class for the playerDeck
        CardStack playerHand = new CardStack(); // Creates CardStack class for the playerHand
        CardStack discardPile = new CardStack(); // Creates CardStack class for the discardPile

        // Creates the deck of 30 Cards with repeating names
        String[] cardNames = {"Luke Skywalker", "Yoda", "Obi-Wan Kenobi", "Leia Organa", "Han Solo",
                "Chewbacca", "Lando Calrissian", "Anakin Skywalker", "Padme Amidala", "Boba Fett", "Darth Vader",
                "Sheev Palpatine", "Ahsoka Tano", "Rex CT-7567", "Darth Maul", "Cody CC-2224", "Ezra Bridger",
                "Kanan Jarrus", "Mace Windu", "Plo Koon", "Qui-Gon Jin", "R2-D2", "Din Djarin", "Grogu"
        };

        // For loop for creating and pushing 30 Card objects into playerDeck
        for (int i = 0; i < 30; i++) {
            playerDeck.push(new Card(i + 1, cardNames[i % cardNames.length]));
        }

        Random random = new Random(); // Generate random numbers
        Scanner scanner = new Scanner(System.in); //  Used to acquire user input

        // Displays Introductions
        System.out.println("\nWelcome to the 'Star Wars Card Deck' where you get the chance to play a");
        System.out.println("card deck and learn the Unique characters found in the Star Wars Galaxy.");
        System.out.println("\nPress 'Enter' to have the power of the Force to choose whether you");
        System.out.println("Draw Cards, Discard Cards or to Retrieve the card from the discarded pile.");
        System.out.println("May the Force be With You!!");

        // Loop continues to execute as long the player's deck is not empty
        while (!playerDeck.isEmpty()) {
            System.out.println("\nPress Enter to proceed to the next turn."); // Print 'Press Enter Text'
            scanner.nextLine();  // Wait for user input to press Enter

            int action = random.nextInt(3); //  // Generate Random Actions which are: 0 = draw, 1 = discard, 2 = retrieve)
            int cardCount = random.nextInt(5) + 1; // // Generates Random Number of cards drawn between 1 and 5

            switch (action) {
                case 0: // Draws X number of cards
                    System.out.println("\nDrawing " + cardCount + " card/s.");
                    for (int i = 0; i < cardCount && !playerDeck.isEmpty(); i++) {
                        playerHand.push(playerDeck.pop());
                    }
                    break;
                case 1: // Discards X number of cards
                    System.out.println("\nDiscarding " + cardCount + " card/s.");
                    for (int i = 0; i < cardCount && !playerHand.isEmpty(); i++) {
                        discardPile.push(playerHand.pop());
                    }
                    break;
                case 2:// Retrieves X number of cards from the Discard pile
                    System.out.println("\nRetrieving " + cardCount + " card/s from the discarded pile.");
                    for (int i = 0; i < cardCount && !discardPile.isEmpty(); i++) {
                        playerHand.push(discardPile.pop());
                    }
                    break;
            }

            // Displays Cards currently in the player hand
            System.out.println("Player Hand: ");
            playerHand.display();

            // Displays the remaining number of cards in the deck
            System.out.println("Remaining Deck: " + playerDeck.size());

            // Displays the number of cards in the discarded pile
            System.out.println("Discarded Pile: " + discardPile.size());
        }

        //Displays the Game Over Text once the Card Deck is emptied
        System.out.println("\nGame Over! The Player Deck is finally Empty.");
        scanner.close();
    }
}