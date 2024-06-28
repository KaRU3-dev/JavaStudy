package ui;

import java.util.Scanner;

import game.SpiderSolitaire;

public class ConsoleUI {
    private SpiderSolitaire game;
    private Scanner scanner;

    public ConsoleUI() {
        game = new SpiderSolitaire();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Spider Solitaire!");
        game.display();
        while (true) {
            System.out.println("Enter your move (q to quit): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                int fromPile = Integer.parseInt(parts[0]) - 1;
                int toPile = Integer.parseInt(parts[1]) - 1;
                int numCards = Integer.parseInt(parts[2]);
                if (game.moveCard(fromPile, toPile, numCards)) {
                    System.out.println("Move successful.");
                } else {
                    System.out.println("Invalid move.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
            game.display();
        }

        System.out.println("Congratulations! You've won the game!");
    }
}
