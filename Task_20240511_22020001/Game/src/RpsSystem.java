import java.util.Scanner;
import java.util.Random;

/**
 * This class is the main class for the Rock, Paper, Scissors game. It will handle the game logic.
 */
public class RpsSystem {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static String Execute() {
        // Show start message
        System.out.println("Rock, Paper, Scissors to start!");

        // Determine the winner
        String result = "";
        do {
            // Get the player's choice
            System.out.print("Enter your choice (rock, paper, or scissors):");
            String playerChoice = scanner.next();

            // Generate the computer's choice
            String computerChoice = GenerateComputerChoice();

            // Show the choices
            System.out.println("Player choice: " + playerChoice);
            System.out.println("Computer choice: " + computerChoice);

            // Determine the winner
            result = DetermineWinner(playerChoice, computerChoice);
        } while (result.equals("tie"));

        // Show the result
        System.out.println("Result: " + result);

        return result;
    }

    public static String GenerateComputerChoice() throws IllegalArgumentException{
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    public static String DetermineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
            return "tie";
        } else if (playerChoice.equals("rock") && computerChoice.equals("scissors")
                || playerChoice.equals("paper") && computerChoice.equals("rock")
                || playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            System.out.println("Player wins!");
            return "player";
        } else {
            System.out.println("Computer wins!");
            return "computer";
        }
    }
}
