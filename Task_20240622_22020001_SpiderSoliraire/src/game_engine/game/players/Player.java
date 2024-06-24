package game_engine.game.players;

import game_engine.Support;

public class Player {
    public int[] requestCard() {

        System.out.print("Enter the card number you want to request\n");
        System.out.print("Enter the card position like\n");
        System.out.print("Lane: 1\n");
        System.out.print("Index: 3\n");
        System.out.print("This means you want to request the 3rd card from the (left)1st lane\n");

        System.out.print("Enter the lane number: ");
        String input1 = Support.SCANNER.nextLine();

        System.out.print("Enter the index number: ");
        String input2 = Support.SCANNER.nextLine();

        try {
            int lane = Integer.parseInt(input1);
            int index = Integer.parseInt(input2);
            return new int[]{lane, index};
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return requestCard();
        }
    }

    public int requestToLane() {
        System.out.print("Enter the lane number you want to move the card to: ");
        String input = Support.SCANNER.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return requestToLane();
        }
    }
}
