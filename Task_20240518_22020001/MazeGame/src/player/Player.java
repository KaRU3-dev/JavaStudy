package player;

import maze.Maze;

/**
 * The Player class represents the player and its properties.
 */
public class Player {

    /**
     * The starting position of the player.X.
     */
    public static int playerX = Maze.STARTX;
    /**
     * The starting position of the player.Y.
     */
    public static int playerY = Maze.STARTY;

    /**
     * Move the player in the maze based on the given move.
     * @param move
     * @return true if the player reaches the goal, false otherwise.
     */
    public boolean movePlayer(char move) {
        int newX = playerX;
        int newY = playerY;

        switch (move) {
            case 'w':
            case 'W':
                newX--;
                break;
            case 'a':
            case 'A':
                newY--;
                break;
            case 's':
            case 'S':
                newX++;
                break;
            case 'd':
            case 'D':
                newY++;
                break;
            default:
                System.out.println("Invalid move! Use W, A, S, D.");
                return false;
        }

        if (Maze.isValidMove(newX, newY)) {
            if (Maze.maze[newX][newY] == Maze.GOAL) {
                System.out.println("Congratulations! You reached the goal!");
                return true;
            }
            Maze.maze[playerX][playerY] = Maze.PATH;
            playerX = newX;
            playerY = newY;
            Maze.maze[playerX][playerY] = Maze.PLAYER;
        } else {
            System.out.println("You hit a wall at position (" + playerX + ", " + playerY + ")! Try a different direction.");
        }

        return false;
    }
}
