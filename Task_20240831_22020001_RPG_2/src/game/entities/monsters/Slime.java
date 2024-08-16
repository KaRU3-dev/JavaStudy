package game.entities.monsters;

import game.entities.BaseEntity;
import game.entities.EntityCategory;
import game.entities.IBaseEntity;

public class Slime extends BaseEntity implements IBaseEntity {

    public IBaseEntity DropItem;

    public Slime(int id, EntityCategory category, String name, int health, int attackPower) {
        super(id, category, name, health, attackPower);
    }

    @Override
    public void Walk() {
        System.out.println("Slime is walking");
    }

    @Override
    public int Attack() {
        return getAttackPower();
    }

    @Override
    public void Defend(int incomingDamage) {
        int damage = incomingDamage;
        if (damage > 0) {
            setHealth(getHealth() - damage);
        }
    }

}
