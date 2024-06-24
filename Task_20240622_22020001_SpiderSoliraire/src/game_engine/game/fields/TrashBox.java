package game_engine.game.fields;

import java.util.ArrayList;

import game_engine.game.entities.Card;
import game_engine.game.entities.CardType;

public class TrashBox {
    public ArrayList<Card> Clover;
    public ArrayList<Card> Diamond;
    public ArrayList<Card> Heart;
    public ArrayList<Card> Spade;

    public TrashBox() {
        this.Clover = new ArrayList<Card>();
        this.Diamond = new ArrayList<Card>();
        this.Heart = new ArrayList<Card>();
        this.Spade = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        switch (card.getType()) {
            case CardType.Clover:
                Clover.add(card);
                break;
            case CardType.Diamond:
                Diamond.add(card);
                break;
            case CardType.Heart:
                Heart.add(card);
                break;
            case CardType.Spade:
                Spade.add(card);
                break;
        }
    }

    public int getNumberOfCards(CardType type) {
        switch (type) {
            case CardType.Clover:
                return Clover.size();
            case CardType.Diamond:
                return Diamond.size();
            case CardType.Heart:
                return Heart.size();
            case CardType.Spade:
                return Spade.size();
            default:
                return 0;
        }
    }
}
