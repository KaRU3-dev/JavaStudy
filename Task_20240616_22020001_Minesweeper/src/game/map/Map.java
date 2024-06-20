package game.map;

public class Map {

    /**
     * ユーザーが実際に見る盤面
     */
    public int[][] board;
    /**
     * ユーザーが開いた盤面
     */
    public int[][] openedBoard;

    /**
     * 地雷の配置を表す配列(クラス)
     */
    private MineMap mineMap;

    public Map(int width, int height) {

        // マインを配置
        mineMap = new MineMap(width, height);

        // 盤面のマインの配置を表す配列を初期化
        board = new int[width][height];
        // ユーザーが開いた盤面を初期化
        openedBoard = new int[width][height];

        // 周辺8マスにある地雷の数を設定
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = aroundMineCount(x, y);
            }
        }
    }

    /**
     * 周辺8マスにある地雷の数を設定
     * @param x x座標
     * @param y y座標
     */
    private int aroundMineCount(int x, int y) {
        // 周辺8マスにある地雷の数を設定
        int count = 0;

        // マップの座標が地雷の場合はスキップ
        if (mineMap.map[x][y] == 1) {
            return -1;
        }

        // マスの周囲8マスに地雷があるかどうかを判定

        // 左上
        if (x > 0 && y > 0 && mineMap.map[x - 1][y - 1] == 1) {
            count++;
        }
        // 上
        if (y > 0 && mineMap.map[x][y - 1] == 1) {
            count++;
        }
        // 右上
        if (x < mineMap.map.length - 1 && y > 0 && mineMap.map[x + 1][y - 1] == 1) {
            count++;
        }
        // 左
        if (x > 0 && mineMap.map[x - 1][y] == 1) {
            count++;
        }
        // 右
        if (x < mineMap.map.length - 1 && mineMap.map[x + 1][y] == 1) {
            count++;
        }
        // 左下
        if (x > 0 && y < mineMap.map[0].length - 1 && mineMap.map[x - 1][y + 1] == 1) {
            count++;
        }
        // 下
        if (y < mineMap.map[0].length - 1 && mineMap.map[x][y + 1] == 1) {
            count++;
        }
        // 右下
        if (x < mineMap.map.length - 1 && y < mineMap.map[0].length - 1 && mineMap.map[x + 1][y + 1] == 1) {
            count++;
        }

        return count;
    }

    /**
     * マスが開かれているかどうかを判定
     * @param x x座標
     * @param y y座標
     * @return マスが開かれているかどうか
     */
    public boolean isOpened(int x, int y) {
        if (openedBoard[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * マスが地雷かどうかを判定
     * @param x x座標
     * @param y y座標
     * @return マスが地雷かどうか
     */
    public boolean isMine(int x, int y) {
        if (mineMap.map[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ゲームクリアかどうかを判定
     * @return ゲームクリアかどうか
     */
    public boolean isGameClear() {
        // 開いていないマスが、全て地雷の場合はゲームクリア
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (openedBoard[x][y] == 0 && mineMap.map[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * マスを開く
     * @param x x座標
     * @param y y座標
     */
    public void open(int x, int y) {
        // マスを開く
        openedBoard[x][y] = 1;
    }

    /**
     * 盤面を表示
     */
    public void showBoard() {
        // 盤面を表示
        for (int y = 0; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (openedBoard[x][y] == 1) {
                    System.out.print(board[x][y]);
                } else {
                    System.out.print("■");
                }
            }
            System.out.println();
        }
    }
}
