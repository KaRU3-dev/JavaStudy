import game.Game;

public class Minesweeper {
    public static void main(String[] args) throws Exception {
        // 文字コードをUTF-8に設定
        System.setProperty("file.encoding", "UTF-8");

        // ゲームを作成
        Game game = new Game();

        // ゲームを開始
        game.Update();
    }
}
