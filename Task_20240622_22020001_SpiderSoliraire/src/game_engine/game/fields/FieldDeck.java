package game_engine.game.fields;

import java.util.ArrayList;

import game_engine.game.entities.Card;

public class FieldDeck {
    /**
     * The cards in the deck.
     * 10 cards.
     */
    public ArrayList<Card> cards;
    /**
     * Status of the empty deck.
     */
    public boolean isDeckEmpty;

    public FieldDeck() {
        this.cards = new ArrayList<Card>();
        this.isDeckEmpty = false;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }
}
