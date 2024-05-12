/**
 * This class is used to store the game data.
 */
public class GameData {
    /**
     * Game start flag
     */
    public boolean isGameStart = false;

    /**
     * Field of the game board (3x3)
     */
    public int[][] field = new int[3][3];

    /**
     * Player first flag
     * @boolean If true, the player is the first to move.
     */
    public boolean isPlayerFirst = false;
}
