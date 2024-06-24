package game_engine.game.entities;

import java.util.ArrayList;

public class Suit {
    /**
     * The type of the suit.
     */
    public CardType type;
    /**
     * The cards in the suit.
     */
    public ArrayList<Card> cards;
    /**
     * The id of the suit.
     */
    public int suitId;

    public Suit(CardType type, int suitId) {
        this.type = type;
        this.suitId = suitId;
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }
}
