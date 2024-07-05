package game.entity.has_life.friendly;

import game.entity.has_life.CharacterType;
import game.entity.has_life.LifeEntityBase;
import game.entity.has_life.Region;

public class Player extends LifeEntityBase implements IFriendlyEntity {
    public String Name = "Your name";
    public Region From = Region.MyFreedomCountry;

    public CharacterType Job = CharacterType.Shielder;

    // アイテムスロットの提案
    // public ArrayList<Pocket> = new ArrayList<Pocket>;
}
