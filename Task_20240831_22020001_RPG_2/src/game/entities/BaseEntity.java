package game.entities;

public class BaseEntity {
    private int id;
    private EntityCategory category;
    private String name;

    private int Health;
    private int AttackPower;

    public BaseEntity(int id, EntityCategory category, String name, int Health, int AttackPower) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.Health = Health;
        this.AttackPower = AttackPower;
    }

    public int getId() {
        return id;
    }

    public EntityCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getHealth() {
        return Health;
    }

    public int getAttackPower() {
        return AttackPower;
    }
}
