package game.players;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);

    public int[] open() {
        // マスを開く
        System.out.println("Enter x, y to open (range is 0 to 31):");
        System.out.print("x: ");
        int x = scanner.nextInt();
        System.out.print("y: ");
        int y = scanner.nextInt();

        return new int[]{x, y};
    }
}
