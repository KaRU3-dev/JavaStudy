package game_engine.game;

import game_engine.game.entities.Card;
import game_engine.game.generator.DefaultDeckGenerator;
import game_engine.game.generator.FieldDeckGenerator;
import game_engine.game.generator.LaneGenerator;
import game_engine.game.generator.PlayerGenerator;
import game_engine.game.generator.ShuffledDeckGenerator;

public class GameMain {

    /**
     * The components of the game.
     */
    public static GameComponents components;

    /**
     * Initializes the game.
     */
    public static void InitializeGame() {
        // Generate components
        components = new GameComponents();

        // Generate default decks
        DefaultDeckGenerator.GenerateDefaultDecks(components);
        // Generate cards
        DefaultDeckGenerator.GenerateAllCards(components);

        // Generate shuffled deck
        ShuffledDeckGenerator.GenerateShuffledDeck(components);

        // Create Lane
        LaneGenerator.GenerateLanes(components);
        // Give cards to lanes
        LaneGenerator.GiveCardsToLanes(components);

        // Generate deck
        FieldDeckGenerator.GenerateDeck(components);
        // Give cards to decks
        FieldDeckGenerator.GiveCardsToDecks(components);

        // Set movable cards
        for (int i = 1; i <= components.Lanes.size(); i++) {
            for (int j = 0; j < components.Lanes.get(i).cards.size(); j++) {
                components.Lanes.get(i).validMovableCards(j);
            }
        }

        // Set flipped cards
        for (int i = 1; i <= components.Lanes.size(); i++) {
            for (int j = 0; j < components.Lanes.get(i).cards.size(); j++) {
                Card card = components.Lanes.get(i).cards.get(j);
                if (card.isMovable) {
                    card.flip();
                }
            }
        }
    }

    /**
     * Starts the game.
     */
    public static void StartGame() {
        // Generate players
        PlayerGenerator.GeneratePlayers(components);

        // Start the game
        components.IsGameStarted = true;
    }

    /**
     * Updates the game.
     */
    public static void UpdateGame() {
        while(components.IsGameStarted) {
            // Set movable cards
            for (int i = 1; i <= components.Lanes.size(); i++) {
                for (int j = 0; j < components.Lanes.get(i).cards.size(); j++) {
                    components.Lanes.get(i).validMovableCards(j);
                }
            }

            // Show the field
            for (int i = 1; i <= components.Lanes.size(); i++) {
                int laneNumber = i;
                if (laneNumber < 10) {
                    System.out.print("Lane  " + i + ": ");
                } else {
                    System.out.print("Lane " + i + ": ");
                }
                for (int j = 0; j < components.Lanes.get(i).cards.size(); j++) {
                    if (components.Lanes.get(i).cards.get(j).isFaceUp) {
                        System.out.print(components.Lanes.get(i).cards.get(j).getType() + " " + components.Lanes.get(i).cards.get(j).getNumber() + ", ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }

            // Set movable cards
            for (int i = 1; i <= components.Lanes.size(); i++) {
                for (int j = 0; j < components.Lanes.get(i).cards.size(); j++) {
                    components.Lanes.get(i).validMovableCards(j);
                }
            }


            // Update the field
            // Request players to action
            int[] playerTurns = new int[2];
            do {
                playerTurns = components.player.requestCard();
                playerTurns[1] -= 1;
            } while (!components.Lanes.get(playerTurns[0]).isMovable(playerTurns[1]));
            int toLaneNumber = 0;
            do {
                toLaneNumber = components.player.requestToLane();
            } while (1 < toLaneNumber && toLaneNumber > components.Lanes.size());

            // Get target card
            int laneNumber = playerTurns[0];
            int index = playerTurns[1];

            // Get the card
            Card targetCard = components.Lanes.get(laneNumber).cards.get(index);

            // Move the card
            components.Lanes.get(toLaneNumber).addCard(targetCard);
            components.Lanes.get(laneNumber).cards.remove(targetCard);

            // Check the lane is start any cardType and 1 to 13
            if (components.Lanes.get(toLaneNumber).cards.size() == 13) {
                int validationNum = 0;

                for (int j = 0; j < components.Lanes.get(toLaneNumber).cards.size(); j++) {
                    if (components.Lanes.get(toLaneNumber).cards.get(j).getNumber() == validationNum) {
                        validationNum++;
                    } else {
                        break;
                    }
                }

                if (validationNum == 13) {
                    components.Lanes.get(toLaneNumber).cards.clear();
                }
            }

            // Check the any lane is empty and trashBox is filled
            int laneEmptyCount = 0;
            for (int j = 1; j <= components.Lanes.size(); j++) {
                if (components.Lanes.get(j).cards.size() == 0) {
                    laneEmptyCount++;
                }
            }
            if (laneEmptyCount == components.Lanes.size()) {
                int trashedCardCount = components.TrashBox.Clover.size()
                                        + components.TrashBox.Diamond.size()
                                        + components.TrashBox.Heart.size()
                                        + components.TrashBox.Spade.size();

                if (trashedCardCount == 52) {
                    components.IsGameStarted = false;
                    components.IsGameWin = true;
                }
            }
        }

        if (components.IsGameWin) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }
}
