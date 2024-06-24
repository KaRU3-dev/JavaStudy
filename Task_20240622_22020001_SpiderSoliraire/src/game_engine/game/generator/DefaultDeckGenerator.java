package game_engine.game.generator;

import game_engine.game.GameComponents;
import game_engine.game.entities.Card;
import game_engine.game.entities.CardType;
import game_engine.game.fields.DefaultDeck;

public class DefaultDeckGenerator {

    public static void GenerateDefaultDecks(GameComponents components) {
        components.DefaultDecks.put(1, new DefaultDeck());
        components.DefaultDecks.put(2, new DefaultDeck());
    }

    public static void GenerateAllCards(GameComponents components) {
        // Generate clover cards
        for (int i = 1; i <= 13; i++) {
            // Add clover cards to default decks
            components.DefaultDecks.get(1).Clover.add(new Card(CardType.Clover, i));
            components.DefaultDecks.get(2).Clover.add(new Card(CardType.Clover, i));

            // Add diamond cards to default decks
            components.DefaultDecks.get(1).Diamond.add(new Card(CardType.Diamond, i));
            components.DefaultDecks.get(2).Diamond.add(new Card(CardType.Diamond, i));

            // Add heart cards to default decks
            components.DefaultDecks.get(1).Heart.add(new Card(CardType.Heart, i));
            components.DefaultDecks.get(2).Heart.add(new Card(CardType.Heart, i));

            // Add spade cards to default decks
            components.DefaultDecks.get(1).Spade.add(new Card(CardType.Spade, i));
            components.DefaultDecks.get(2).Spade.add(new Card(CardType.Spade, i));
        }
    }
}
