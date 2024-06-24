package game_engine.game.entities;

/**
 * A class representing a card.
 */
public class Card {
    /**
     * The type of the card.
     */
    private CardType type;
    /**
     * The number of the card.
     */
    private int number;
    /**
     * Whether the card is face up or not.
     */
    public boolean isFaceUp = false;
    /**
     * Whether the card is movable or not.
     */
    public boolean isMovable = false;

    public Card(CardType type, int number) {
        this.type = type;
        this.number = number;
    }

    /**
     * Returns the type of the card.
     * @return the type of the card.
     */
    public CardType getType() {
        return type;
    }

    /**
     * Returns the number of the card.
     * @return the number of the card.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Flips the card.
     */
    public void flip() {
        isFaceUp = !isFaceUp;
    }
}
