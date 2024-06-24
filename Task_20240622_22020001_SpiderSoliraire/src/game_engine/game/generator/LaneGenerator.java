package game_engine.game.generator;

import game_engine.game.GameComponents;
import game_engine.game.fields.Lane;

public class LaneGenerator {
    public static void GenerateLanes(GameComponents components) {
        components.Lanes.put(1, new Lane(1, 6));
        components.Lanes.put(2, new Lane(2, 6));
        components.Lanes.put(3, new Lane(3, 6));
        components.Lanes.put(4, new Lane(4, 6));
        components.Lanes.put(5, new Lane(5, 5));
        components.Lanes.put(6, new Lane(6, 5));
        components.Lanes.put(7, new Lane(7, 5));
        components.Lanes.put(8, new Lane(8, 5));
        components.Lanes.put(9, new Lane(9, 5));
        components.Lanes.put(10, new Lane(10, 5));
    }

    public static void GiveCardsToLanes(GameComponents components) {
        for (int i = 1; i <= 10; i++) {
            Lane lane = components.Lanes.get(i);
            for (int j = 0; j < lane.getDefaultCardCount(); j++) {
                lane.addCard(components.ShuffledDeck.get(0));
                components.ShuffledDeck.remove(0);
            }
        }
    }
}
