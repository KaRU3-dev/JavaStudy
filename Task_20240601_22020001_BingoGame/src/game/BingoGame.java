package game;

public class BingoGame {

    public void Start() {
        // Request player name.
        String name = Data.director.GetPlayerName();

        // Generate player.
        Data.players.add(new Players(name));

        // Generate and give bingo card.
        Data.players.forEach(player -> {
            player.card = (int[][]) Data.director.GiveBingoCard();
        });

        // Activate game
        Data.isStart = true;
    }

    public void Update() {
        // Game loop
        while (Data.isStart) {
            // Show players card.
            Data.players.get(0).ShowCard();

            // Decide number.
            int turnNum = 0;
            do {
                turnNum = Data.director.GetRandomNumber();
            } while(Data.pickedNumbers.contains(turnNum));

            // Add turn num to picked num list.
            Data.pickedNumbers.add(turnNum);

            // Check player card.
            String[] isBingo = { Data.players.get(0).CheckCard(turnNum) };

            // Check who win this game
            boolean win = Data.director.WhoWin(isBingo);

            // If someone win end game
            if (win) {
                Data.isStart = false;
            }
        }

        // Show result
        Data.director.ShowResult();
        Data.winedPlayers.forEach(player -> {
            // Show win player name
            System.out.println(player.name);
            // Show win player card
            player.ShowCard();
        });
    }
}
