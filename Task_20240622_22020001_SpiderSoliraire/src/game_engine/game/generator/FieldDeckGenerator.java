package game_engine.game.generator;

import game_engine.game.GameComponents;
import game_engine.game.fields.FieldDeck;

public class FieldDeckGenerator {
    public static void GenerateDeck(GameComponents components) {
        for (int i = 1; i <= 5; i++) {
            components.FieldDecks.put(i, new FieldDeck());
        }
    }

    public static void GiveCardsToDecks(GameComponents components) {
        for (int i = 1; i <= 5; i++) {
            FieldDeck deck = components.FieldDecks.get(i);
            for (int j = 1; j <= 10; j++) {
                deck.addCard(components.ShuffledDeck.get(0));
                components.ShuffledDeck.remove(0);
            }
        }
    }
}
