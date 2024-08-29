package game;

import java.util.Scanner;

import maze.Maze;
import player.Player;

/**
 * The Game class represents the main game logic and controls the flow of the
 * game.
 */
public class MazeGame {

    private static Maze maze = new Maze();
    private static Player player = new Player();

    /**
     * Flag to check if the game is running.
     */
    private static boolean isGameRunning = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        isGameRunning = true;

        while (isGameRunning) {
            maze.printMaze();

            System.out.print("Enter your move (W, A, S, D): ");
            char move = scanner.next().charAt(0);

            if (move == 'q' || move == 'Q') {
                isGameRunning = false;
                System.out.println("Game over!");
                continue;
            }

            if (player.movePlayer(move)) {
                isGameRunning = false;
            }
        }

        scanner.close();
    }
}
