package game.entity.Item.Armors.Head;

public class HeadArmorBase {
    /**
     * 防御力
     */
    public int Shield = 10;
    /**
     * 速度
     */
    public int Speed = 2;
    /**
     * 攻撃力効果上昇
     */
    public int DamageUp = 3;

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

    public void SetDamageUp(int x) {
        DamageUp = x;
    }
    public int GetDamageUp() {
        return DamageUp;
    }
}
