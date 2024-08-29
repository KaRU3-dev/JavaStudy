import game.BingoGame;

public class Task_20240601_22020001_BingoGame {
    public static void main(String[] args) throws Exception {
        // #region Idea
        // class:
        // BingoGame
        // Data
        // Director
        // generator/BingoCard
        // generator/Players

        ////////////// Game Flow //////////////
        // Generate players
        // Generate director
        // Generate bingo card and give to players

        // Start game (loop)

        // 1. Show bingo card to player
        // 2. Generate turn number 1 ~ 99
        // 2.1 Check picked numbers
        // 2.2 If exist, jump to 2
        // 3. Check Hit or None hit
        // 3.1 If hit, the number position of the card is set to 0
        // 4. Update player bingo card
        // 4.1. Add turn number to picked number
        // 5. Check Bingo!
        // 5.1 If someone bing, end game.

        // Show win players.

        // #endregion

        // #region Start game
        BingoGame game = new BingoGame();
        game.Start();
        game.Update();
        // #endregion
    }
}
