package maze;

import player.Player;

/**
 * The MazeInitializer class initializes the maze with walls and paths.
 */
public class MazeInitializer {

    /**
     * Initialize the maze with walls and paths.
     */
    public char[][] initializeMaze() {
        // Initialize maze with walls and paths
        String[] mazeStr = {
            "##########",
            "#S    #  #",
            "# ## ## ##",
            "# ##  # ##",
            "# ##    ##",
            "#####  ###",
            "#        #",
            "# ###### #",
            "#       G#",
            "##########"
        };

        char[][] maze = new char[Maze.HEIGHT][Maze.WIDTH];

        for (int i = 0; i < Maze.HEIGHT; i++) {
            for (int j = 0; j < Maze.WIDTH; j++) {
                maze[i][j] = mazeStr[i].charAt(j);
                if (maze[i][j] == Maze.START) {
                    Player.playerX = i;
                    Player.playerY = j;
                }
            }
        }

        return maze;
    }
}
