package game;
public class BingoCard {
    public static Object Generate(int width, int height, int minNum, int maxNum) {
        int[][] sample = new int[height][width];

        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < sample[i].length; j++) {
                sample[i][j] = Data.random.nextInt(minNum, maxNum);
            }
        }

        return sample;
    }
}
