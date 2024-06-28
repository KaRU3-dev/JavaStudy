package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.card.Card;
import game.card.Rank;
import game.card.Suit;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }
}
