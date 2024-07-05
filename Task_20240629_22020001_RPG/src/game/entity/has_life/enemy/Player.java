package game.entity.has_life.enemy;

import game.entity.has_life.CharacterType;
import game.entity.has_life.LifeEntityBase;
import game.entity.has_life.Region;

public class Player extends LifeEntityBase implements IEnemyEntity {
    public String Name = "The monster";
    public Region From = Region.EnemyCountry;

    public CharacterType Job = CharacterType.Attacker;
}
