package game_engine.game;

import java.util.ArrayList;
import java.util.HashMap;

import game_engine.game.entities.Card;
import game_engine.game.fields.DefaultDeck;
import game_engine.game.fields.FieldDeck;
import game_engine.game.fields.Lane;
import game_engine.game.fields.TrashBox;
import game_engine.game.players.Player;

public class GameComponents {

    public boolean IsGameStarted;
    public boolean IsGameWin;

    public HashMap<Integer, DefaultDeck> DefaultDecks;

    public ArrayList<Card> ShuffledDeck;

    public HashMap<Integer, Lane> Lanes;

    public HashMap<Integer, FieldDeck> FieldDecks;

    public TrashBox TrashBox;

    public Player player;

    public GameComponents() {
        this.IsGameStarted = false;
        this.IsGameWin = false;

        this.DefaultDecks = new HashMap<Integer, DefaultDeck>();

        this.ShuffledDeck = new ArrayList<Card>();

        this.Lanes = new HashMap<Integer, Lane>();
        this.FieldDecks = new HashMap<Integer, FieldDeck>();

        this.TrashBox = new TrashBox();

        this.player = new Player();
    }
}
