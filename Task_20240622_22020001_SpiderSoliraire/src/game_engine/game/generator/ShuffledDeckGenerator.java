package game_engine.game.generator;

import game_engine.game.GameComponents;

public class ShuffledDeckGenerator {
    public static void GenerateShuffledDeck(GameComponents components) {
        // Shuffle all cards
        components.ShuffledDeck.addAll(components.DefaultDecks.get(1).Clover);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(1).Diamond);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(1).Heart);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(1).Spade);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(2).Clover);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(2).Diamond);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(2).Heart);
        components.ShuffledDeck.addAll(components.DefaultDecks.get(2).Spade);
        java.util.Collections.shuffle(components.ShuffledDeck);
    }
}
