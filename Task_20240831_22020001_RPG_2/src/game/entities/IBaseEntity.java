package game.entities;

public interface IBaseEntity {
    void Walk();

    int Attack();

    void Defend(int incomingDamage);
}
