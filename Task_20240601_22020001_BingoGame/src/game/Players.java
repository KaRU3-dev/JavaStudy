package game;

public class Players {

    /**
     * Player's name
     */
    public String name;

    /**
     * Player's bingo card
     */
    public int card[][] = new int[Data.cardHeight][Data.cardWidth];

    public Players(String name) {
        this.name = name;
    }

    public String CheckCard(int num) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (num == (int) card[i][j]) {
                    card[i][j] = 0;
                }
            }
        }

        // Add bingo check
        // Horizontal line
        for (int line = 0; line < card.length; line++) {
            int hit = 0;
            for (int cell = 0; cell < card[line].length; cell++) {
                if ((int) card[line][cell] == Data.hittedNumber) {
                    hit++;
                }
            }

            if (hit >= Data.cardWidth) {
                return "Bingo!!";
            }
        }

        // Vertical line
        for (int line = 0; line < card.length; line++) {
            int hit = 0;
            for (int cell = 0; cell < Data.cardHeight; cell++) {
                if ((int) card[line][cell] == Data.hittedNumber) {
                    hit++;
                }
            }

            if (hit >= Data.cardHeight) {
                return "Bingo!!";
            }
        }

        // Oblique line
        if ((int) card[0][0] == Data.hittedNumber) {
            int hit = 0;
            int first = 0;
            int second = 0;
            for (int i = 0; i < Data.cardHeight; i++) {
                if ((int) card[first][second] == Data.hittedNumber) {
                    hit++;
                }

                first++;
                second++;
            }

            if (hit >= Data.cardHeight) {
                return "Bingo!!";
            }
        }
        if ((int) card[0][Data.cardWidth - 1] == Data.hittedNumber) {
            int hit = 0;
            int first = 0;
            int second = Data.cardWidth - 1;
            for (int i = 0; i < Data.cardHeight; i++) {
                if ((int) card[first][second] == Data.hittedNumber) {
                    hit++;
                }

                first++;
                second--;
            }

            if (hit >= Data.cardHeight) {
                return "Bingo!!";
            }
        }

        return "Nah";
    }

    public void ShowCard() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {

                if (card[i][j] > 10) {
                    System.out.print(card[i][j] + " ");
                } else {
                    System.out.print(" " + card[i][j] + " ");
                }
            }

            System.out.print("\n");
        }
    }
}
