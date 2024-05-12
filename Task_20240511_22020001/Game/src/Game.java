import java.util.Random;
import java.util.Scanner;

/**
 * The Game class represents a game instance.
 */
public class Game {

    public RpsSystem rpsSystem = new RpsSystem();
    public GameData gameData = new GameData();
    public Random random = new Random();
    public Scanner scanner = new Scanner(System.in);

    /**
     * Starts the game.
     */
    public void Start() throws Exception {
        // Decide who goes first
        String firstPlayer = RpsSystem.Execute();
        // If the player is first, set the flag to true
        if (firstPlayer.equals("player")) {
            gameData.isPlayerFirst = true;
        }
        // Otherwise, set the flag to false
        else {
            gameData.isPlayerFirst = false;
        }

        // Fill field with empty values
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameData.field[i][j] = 0;
            }
        }

        // Set the game start flag to true
        gameData.isGameStart = true;

        // Call the Update method
        Update();
    }

    /**
     * Updates the game state.
     */
    public void Update() throws Exception {
        if (!gameData.isGameStart) {
            throw new Exception("The game is not started.");
        }

        while (gameData.isGameStart) {
            // Display the game board
            ShowFields();

            // If the player is first
            if (gameData.isPlayerFirst) {
                // Player's turn
                System.out.print("Your turn");
                // Get the player's move
                do {
                    System.out.print("Enter the row (0-2): ");
                    int row = scanner.nextInt();
                    System.out.print("Enter the column (0-2): ");
                    int column = scanner.nextInt();
                    // Check if the cell is empty
                    if (gameData.field[row][column] == 0) {
                        gameData.field[row][column] = 1;
                        break;
                    } else {
                        System.out.println("The cell is not empty. Please try again.");
                    }
                } while (true);

                // Check if the player wins
                if (CheckWin(1)) {
                    System.out.println("Player wins!");
                    gameData.isGameStart = false;
                    break;
                }

                // Computer's turn
                ShowFields();
                System.out.println("Computer's turn");

                // Generate the computer's move
                do {
                    int row = random.nextInt(3);
                    int column = random.nextInt(3);
                    if (gameData.field[row][column] == 0) {
                        gameData.field[row][column] = 2;
                        break;
                    }
                } while (true);

                // Check if the computer wins
                if (CheckWin(2)) {
                    System.out.println("Computer wins!");
                    gameData.isGameStart = false;
                    break;
                }

                // Check if the board is full
                if (CheckFull()) {
                    System.out.println("It's a tie!");
                    gameData.isGameStart = false;
                    break;
                }
            } else {
                // Computer's turn
                System.out.println("Computer's turn");

                // Generate the computer's move
                do {
                    int row = random.nextInt(3);
                    int column = random.nextInt(3);
                    if (gameData.field[row][column] == 0) {
                        gameData.field[row][column] = 2;
                        break;
                    }
                } while (true);

                // Check if the computer wins
                if (CheckWin(2)) {
                    System.out.println("Computer wins!");
                    gameData.isGameStart = false;
                    break;
                }

                // Player's turn
                ShowFields();
                System.out.print("Your turn");
                // Get the player's move
                do {
                    System.out.print("Enter the row (0-2): ");
                    int row = scanner.nextInt();
                    System.out.print("Enter the column (0-2): ");
                    int column = scanner.nextInt();
                    // Check if the cell is empty
                    if (gameData.field[row][column] == 0) {
                        gameData.field[row][column] = 1;
                        break;
                    } else {
                        System.out.println("The cell is not empty. Please try again.");
                    }
                } while (true);

                // Check if the player wins
                if (CheckWin(1)) {
                    System.out.println("Player wins!");
                    gameData.isGameStart = false;
                    break;
                }

                // Check if the board is full
                if (CheckFull()) {
                    System.out.println("It's a tie!");
                    gameData.isGameStart = false;
                    break;
                }
            }
        }

        // Show the final board
        ShowFields();

        // Set the game start flag to false
        gameData.isGameStart = false;
        // Close the scanner
        scanner.close();
    }

    /**
     * Shows the game board.
     */
    public void ShowFields() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                if (gameData.field[i][j] == 0) {
                    System.out.print("- ");
                } else if (gameData.field[i][j] == 1) {
                    System.out.print("X ");
                } else if (gameData.field[i][j] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Checks if the player or computer wins.
     * @param player The player to check (1 for player, 2 for computer).
     * @return True if the player wins, false otherwise.
     */
    public boolean CheckWin(int player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (gameData.field[i][0] == player && gameData.field[i][1] == player && gameData.field[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (gameData.field[0][i] == player && gameData.field[1][i] == player && gameData.field[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (gameData.field[0][0] == player && gameData.field[1][1] == player && gameData.field[2][2] == player) {
            return true;
        }
        if (gameData.field[0][2] == player && gameData.field[1][1] == player && gameData.field[2][0] == player) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the board is full.
     * @return True if the board is full, false otherwise.
     */
    public boolean CheckFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameData.field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
