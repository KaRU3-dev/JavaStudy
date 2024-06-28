package game;

import game.card.Card;
import java.util.ArrayList;
import java.util.List;

public class SpiderSolitaire {
    private List<List<Card>> tableau;
    private Deck deck;

    public SpiderSolitaire() {
        tableau = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tableau.add(new ArrayList<>());
        }
        deck = new Deck();
        deal();
    }

    private void deal() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                Card card = deck.drawCard();
                tableau.get(i).add(card);
            }
            tableau.get(i).get(tableau.get(i).size() - 1).setFaceUp(true);
        }
    }

    public boolean moveCard(int fromPile, int toPile, int numCards) {
        if (fromPile < 0 || fromPile >= tableau.size() || toPile < 0 || toPile >= tableau.size()) {
            return false;
        }

        List<Card> source = tableau.get(fromPile);
        List<Card> destination = tableau.get(toPile);

        if (numCards <= 0 || numCards > source.size()) {
            return false;
        }

        List<Card> movingCards = source.subList(source.size() - numCards, source.size());
        if (!isMoveValid(movingCards, destination)) {
            return false;
        }

        destination.addAll(movingCards);
        movingCards.clear();

        if (!source.isEmpty()) {
            source.get(source.size() - 1).setFaceUp(true);
        }

        checkCompleteSets();
        return true;
    }

    private boolean isMoveValid(List<Card> movingCards, List<Card> destination) {
        if (destination.isEmpty()) {
            return movingCards.get(0).isFaceUp();
        }

        Card topCard = destination.get(destination.size() - 1);
        Card bottomMovingCard = movingCards.get(0);

        return topCard.isFaceUp() && topCard.getRank().ordinal() - 1 == bottomMovingCard.getRank().ordinal();
    }

    private void checkCompleteSets() {
        for (List<Card> pile : tableau) {
            if (pile.size() >= 13 && isCompleteSet(pile.subList(pile.size() - 13, pile.size()))) {
                for (int i = 0; i < 13; i++) {
                    pile.remove(pile.size() - 1);
                }
            }
        }
    }

    private boolean isCompleteSet(List<Card> cards) {
        if (cards.size() != 13) {
            return false;
        }

        for (int i = 0; i < 13; i++) {
            if (cards.get(i).getRank().ordinal() != i) {
                return false;
            }
        }

        return true;
    }

    public boolean isGameWon() {
        for (List<Card> pile : tableau) {
            if (!pile.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < tableau.size(); i++) {
            if (i < 10) {
                System.out.print("Pile " + (i + 1) + " :");
            } else {
                System.out.print("Pile " + (i + 1) + ":");
            }

            for (Card card : tableau.get(i)) {
                if (card.isFaceUp()) {
                    System.out.print(card + " ");
                } else {
                    System.out.print("XX ");
                }
            }
            System.out.println();
        }
    }
}
