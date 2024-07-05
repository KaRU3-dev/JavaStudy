package game.entity.Item.Armors.Body;

public class BodyArmorBase {
    /**
     * 跳躍力
     */
    public int Shield = 10;
    /**
     * 速度
     */
    public int Speed = 2;

    public void SetShield(int x) {
        Shield = x;
    }
    public int GetShield() {
        return Shield;
    }

    public void SetSpeed(int x) {
        Speed = x;
    }
    public int GetSpeed() {
        return Speed;
    }
}
