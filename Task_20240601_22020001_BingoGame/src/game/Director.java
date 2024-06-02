package game;

public class Director {
    public Object GiveBingoCard() {
        return BingoCard.Generate(Data.cardWidth, Data.cardHeight, Data.cardMinimumNumber, Data.cardMaximumNumber);
    }

    public String GetPlayerName() {
        String input = "";

        do {
            System.out.println("Please input your name: ");
            input = Data.scanner.next();
        } while(input.equals(""));

        return input;
    }

    public int GetRandomNumber() {
        return Data.random.nextInt(Data.cardMinimumNumber, Data.cardMaximumNumber);
    }

    public boolean WhoWin(String[] result) {
        boolean someoneWin = false;

        for (int i = 0; i < result.length; i++) {

            System.out.println("Player sais " + result[i]);

            switch (result[i]) {
                case "Bingo!!":
                    someoneWin = true;

                    Data.winedPlayers.add(Data.players.get(i));

                    break;
                default:
                    someoneWin = false;
                    break;
            }
        }

        return someoneWin;
    }

    public void ShowResult() {

        System.out.print("The result is:");

        Data.winedPlayers.forEach(player -> {
            System.out.println(player.name);
        });
    }
}
