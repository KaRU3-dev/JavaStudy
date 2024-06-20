package game.map;

import game.Game;
import support.RandomGenerator;

public class MineMap {

    /**
     * 盤面のマインの配置を表す配列
     */
    public int[][] map;

    public MineMap(int width, int height) {

        // 盤面のマインの配置を表す配列を初期化
        map = new int[width][height];

        // マインを配置
        setMines(width, height);
    }

    /**
     * マインを配置する
     * @param width 盤面の幅
     * @param height 盤面の高さ
     */
    private void setMines(int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // マスが地雷かどうかを判定
                if (isMine(Game.mineProbability, RandomGenerator.randomInt(Game.mineRandomMin, Game.mineRandomMax))) {
                    map[x][y] = 1;
                } else {
                    map[x][y] = 0;
                }
            }
        }
    }

    /**
     * マスが地雷かどうかを判定する
     * @param probability 地雷が配置される確率(random.nextInt(min, max)で生成される乱数がこの値以下の場合、地雷を配置する)
     * @param target 乱数の生成結果
     * @return 地雷の場合true、それ以外の場合false
     */
    private Boolean isMine(int probability, int target) {

        if (probability == target) {
            return true;
        } else {
            return false;
        }
    }
}
