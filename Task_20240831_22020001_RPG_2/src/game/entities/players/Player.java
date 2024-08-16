package game.entities.players;

import java.util.ArrayList;

import game.entities.BaseEntity;
import game.entities.EntityCategory;
import game.entities.IBaseEntity;
import game.entities.items.BaseItem;

public class Player extends BaseEntity implements IBaseEntity {

    public BaseItem HeadSlot = null;
    public BaseItem BodySlot = null;
    public BaseItem LegsSlot = null;
    public BaseItem RightHandSlot = null;
    public BaseItem LeftHandSlot = null;

    public ArrayList<BaseItem> Inventory = new ArrayList<BaseItem>();

    public Player(int id, EntityCategory category, String name, int health, int attackPower) {
        super(id, category, name, health, attackPower);
    }

    @Override
    public void Walk() {
        System.out.println("Player is walking");
    }

    @Override
    public int Attack() {
        return getAttackPower() + RightHandSlot.getAttackPower();
    }

    @Override
    public void Defend(int incomingDamage) {
        int damage = incomingDamage - BodySlot.getDefensePower() - LegsSlot.getDefensePower()
                - HeadSlot.getDefensePower() - RightHandSlot.getDefensePower() - LeftHandSlot.getDefensePower();
        if (damage > 0) {
            setHealth(getHealth() - damage);
        }
    }

    public int getDefendPower() {
        return BodySlot.getDefensePower() + LegsSlot.getDefensePower() + HeadSlot.getDefensePower()
                + RightHandSlot.getDefensePower() + LeftHandSlot.getDefensePower();
    }

    public void setHandSlot(BaseItem item, boolean isRightHand) {
        if (isRightHand) {
            RightHandSlot = item;
        } else {
            LeftHandSlot = item;
        }
    }

    public void removeHandSlot(boolean isRightHand) {
        if (isRightHand) {
            RightHandSlot = null;
        } else {
            LeftHandSlot = null;
        }
    }

    public void setHeadSlot(BaseItem item) {
        HeadSlot = item;
    }

    public void removeHeadSlot() {
        HeadSlot = null;
    }

    public void setBodySlot(BaseItem item) {
        BodySlot = item;
    }

    public void removeBodySlot() {
        BodySlot = null;
    }

    public void setLegsSlot(BaseItem item) {
        LegsSlot = item;
    }

    public void removeLegsSlot() {
        LegsSlot = null;
    }

    public void addItemToInventory(BaseItem item) {
        Inventory.add(item);
    }

    public void removeItemFromInventory(BaseItem item) {
        Inventory.remove(item);
    }

    public void showInventory() {
        for (BaseItem item : Inventory) {
            System.out.println(item.getName());
        }
    }

    public void showEquippedItems() {
        System.out.println("Head: " + HeadSlot.getName());
        System.out.println("Body: " + BodySlot.getName());
        System.out.println("Legs: " + LegsSlot.getName());
        System.out.println("Right Hand: " + RightHandSlot.getName());
        System.out.println("Left Hand: " + LeftHandSlot.getName());
    }
}
