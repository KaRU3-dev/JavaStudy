import game.GameDifficulty;
import game.GameSystem;

public class Task_20240831_22020001_RPG_2 {
    public static void main(String[] args) throws Exception {
        // Create game system
        GameSystem gameSystem = new GameSystem(GameDifficulty.NORMAL);

        // Start game
        gameSystem.Game();
    }
}
