import java.util.Random;
import java.util.Scanner;

/**
 * 問題
 *     乱数生成とif文を使用してガチャプログラムを作成してみてください。
 */
public class App {

    public static boolean IsRunning = false;
    public static int Rarity = 6;

    public static void main(String[] args) throws Exception {

        // スタート
        IsRunning = true;

        // 初期化
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // メインループ
        while (IsRunning) {
            // ガチャを引く
            boolean IsPick = Pick(scanner);
            if (!IsPick) {
                IsRunning = false;
                break;
            } else {
                // ガチャの結果を表示
                int value = NumberGenerator(random);
                String rarity = RarityStarGenerator(value);
                System.out.println("Result: " + rarity);
            }
            // もう一度引くか確認
            IsRunning = IsContinue(scanner);
        }

        // 終了処理
        scanner.close();
        System.out.println("Bye");
    }

    /**
     * ガチャを引くか確認する
     * @param scanner
     * @return boolean
     */
    public static boolean Pick(Scanner scanner) {
        System.out.print("Pick? (y/n)");
        String input = scanner.next();
        return input.equals("y");
    }

    /**
     * ランダムな数値を生成する (1 ~ Rarity)
     * @param rnd
     * @return int
     */
    public static int NumberGenerator(Random rnd) {
        int rndValue = rnd.nextInt(1, Rarity + 1);
        return rndValue;
    }

    /**
     * レアリティの星を生成する
     * @param value
     * @return String
     * @throws Exception 
     */
    public static String RarityStarGenerator(int value) throws Exception {
        switch (value) {
            case 1:
                return "|";
            case 2:
                return "||";
            case 3:
                return "|||";
            case 4:
                return "||||";
            case 5:
                return "|||||";
            case 6:
                return "||||||";
            default:
                throw new Exception("Invalid value");
        }
    }

    /**
     * もう一度引くか確認する
     * @param scanner
     * @return boolean
     */
    public static boolean IsContinue(Scanner scanner) {
        System.out.print("Pick again？ (y/n)");
        String input = scanner.next();
        return input.equals("y");
    }
}
