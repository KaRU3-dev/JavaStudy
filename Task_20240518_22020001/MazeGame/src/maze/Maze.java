package maze;

/**
 * The Maze class represents the maze and its properties.
 */
public class Maze {
    /**
     * The width and height of the maze.
     */
    public static final int WIDTH  = 10;
    /**
     * The width and height of the maze.
     */
    public static final int HEIGHT = 10;

    /**
     * The characters used to represent the maze elements (wall).
     */
    public static final char WALL   = '#';
    /**
     * The characters used to represent the maze elements (load).
     */
    public static final char PATH   = ' ';
    /**
     * The characters used to represent the maze elements (start).
     */
    public static final char START  = 'S';
    /**
     * The characters used to represent the maze elements (goal).
     */
    public static final char GOAL   = 'G';
    /**
     * The characters used to represent the maze elements (player).
     */
    public static final char PLAYER = 'P';

    /**
     * The maze represented as a 2D character array.
     */
    public static char[][] maze = new char[HEIGHT][WIDTH];

    /**
     * The starting position of the player.X.
     */
    public static final int STARTX = 0;
    /**
     * The starting position of the player.Y.
     */
    public static final int STARTY = 0;

    // Initializer for maze
    private MazeInitializer mazeInitializer = new MazeInitializer();

    public Maze() {
        maze = mazeInitializer.initializeMaze();
    }

    /**
     * Check if the given position is a valid move.
     */
    public static boolean isValidMove(int x, int y) {
        return x >= 0 && x < HEIGHT && y >= 0 && y < WIDTH && maze[x][y] != WALL;
    }

    /**
     * Print the maze to the console.
     */
    public void printMaze() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
