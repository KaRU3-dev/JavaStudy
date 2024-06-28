package game.card;

public class Card {
    private final Suit suit;
    private final Rank rank;
    private boolean isFaceUp;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.isFaceUp = false;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
