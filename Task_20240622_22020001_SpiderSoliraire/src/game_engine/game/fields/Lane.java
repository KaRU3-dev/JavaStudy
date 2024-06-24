package game_engine.game.fields;

import java.util.ArrayList;

import game_engine.game.entities.Card;

/**
 * A class representing a lane in the field.
 */
public class Lane {
    /**
     * The id of the lane.
     */
    private int id;
    /**
     * The default number of cards in the lane.
     */
    private int defaultCardCount;
    /**
     * The cards in the lane.
     */
    public ArrayList<Card> cards;

    public Lane(int id, int defaultCardCount) {
        this.id = id;
        this.defaultCardCount = defaultCardCount;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Returns the id of the lane.
     * @return the id of the lane.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the default number of cards in the lane.
     * @return the default number of cards in the lane.
     */
    public int getDefaultCardCount() {
        return defaultCardCount;
    }

    /**
     * Adds a card to the lane.
     * @param card the card to add.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes a card from the lane.
     * @param card the card to remove.
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    public boolean isMovable(int index) {
        return cards.get(index).isMovable;
    }

    public void validMovableCards(int index) {
        // If the card position is the last card in the lane
        if (cards.get(cards.size() - 1) == cards.get(index)) {
            cards.get(index).isMovable = true;
        } else if (cards.get(index).getType() == cards.get(index + 1).getType() && cards.get(index).getNumber() == cards.get(index + 1).getNumber() - 1) {
            cards.get(index).isMovable = true;
        }
    }

    public void validFaceUpCard() {
        // If the card position is the last card in the lane
        cards.get(cards.size() - 1).isFaceUp = true;
    }
}
