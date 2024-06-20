package game;

import game.map.Map;
import game.players.Player;

public class Game {

    public static int mapWidth = 32;
    public static int mapHeight = 32;

    public static int mineRandomMin = 0;
    public static int mineRandomMax = 10;
    public static int mineProbability = 3;

    public Boolean isGameStart = false;
    public Boolean isGameOver = false;

    public Map map;
    public Player player;

    public Game() {
        // マップを作成
        map = new Map(mapWidth, mapHeight);

        // プレイヤーを作成
        player = new Player();

        // ゲームを開始
        isGameStart = true;
    }

    public void Update() {
        // ゲームを開始できていない場合は例外を投げる
        if (!isGameStart) {
            throw new IllegalStateException("Game is not started yet.");
        }

        while (!isGameOver) {
            // コンソールをクリア
            System.out.print("\033[H\033[2J");

            // ボードを表示
            map.showBoard();
            // ユーザーがx, yを入力し、そのマスを開く
            int[] openPosition;
            do {
                openPosition = player.open();
            } while (map.isOpened(openPosition[0], openPosition[1]));

            // マスを開き、マスの内容を表示
            map.open(openPosition[0], openPosition[1]);
            // マスが地雷だったらゲームオーバー、それ以外は続行(マスの数字を表示)
            if (map.isMine(openPosition[0], openPosition[1])) {
                isGameOver = true;
                break;
            }

            // 開いていないマスが、全て地雷の場合はゲームクリア
            if (map.isGameClear()) {
                System.out.println("Game Clear!");
                break;
            }
        }

        // ゲームオーバー
        if (isGameOver) {
            // コンソールをクリア
            System.out.print("\033[H\033[2J");
            // ボードを表示
            map.showBoard();

            // ゲームオーバーを表示
            System.out.println("Game Over!");
        } else {
            // コンソールをクリア
            System.out.print("\033[H\033[2J");
            // ボードを表示
            map.showBoard();

            // ゲームクリア
            System.out.println("Game Clear!");
        }
    }
}
