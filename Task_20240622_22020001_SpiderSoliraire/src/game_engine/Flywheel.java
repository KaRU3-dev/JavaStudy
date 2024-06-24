package game_engine;

import game_engine.game.GameMain;

/**
 * A class representing the Game Engine's Flywheel.
 */
public class Flywheel {
    public static void Awake() {
        GameMain.InitializeGame();
    }

    public static void Start() {
        GameMain.StartGame();
    }

    public static void Update() {
        GameMain.UpdateGame();
    }
}
