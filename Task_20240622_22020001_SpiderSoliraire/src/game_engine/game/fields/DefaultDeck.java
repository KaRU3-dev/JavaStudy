package game_engine.game.fields;

import java.util.ArrayList;

import game_engine.game.entities.Card;

public class DefaultDeck {
    public ArrayList<Card> Clover;
    public ArrayList<Card> Diamond;
    public ArrayList<Card> Heart;
    public ArrayList<Card> Spade;

    public DefaultDeck() {
        this.Clover = new ArrayList<Card>();
        this.Diamond = new ArrayList<Card>();
        this.Heart = new ArrayList<Card>();
        this.Spade = new ArrayList<Card>();
    }
}
