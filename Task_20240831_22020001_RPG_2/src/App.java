import game.GameDifficulty;
import game.GameSystem;

public class App {
    public static void main(String[] args) throws Exception {
        // Create game system
        GameSystem gameSystem = new GameSystem(GameDifficulty.NORMAL);

        // Start game
        gameSystem.Game();
    }
}
