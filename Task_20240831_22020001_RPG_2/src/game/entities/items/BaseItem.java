package game.entities.items;

import game.entities.BaseEntity;
import game.entities.EntityCategory;

public class BaseItem extends BaseEntity {

    private int DefensePower;

    public BaseItem(int id, EntityCategory category, String name, int health, int attackPower, int defensePower) {
        super(id, category, name, health, attackPower);

        DefensePower = defensePower;
    }

    public int getDefensePower() {
        return DefensePower;
    }
}
