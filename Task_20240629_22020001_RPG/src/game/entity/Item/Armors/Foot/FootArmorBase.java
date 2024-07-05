package game.entity.Item.Armors.Foot;

public class FootArmorBase {
    /**
     * 跳躍力
     */
    public int Jump = 10;
    /**
     * 速度
     */
    public int Speed = 2;
    /**
     * 攻撃力効果上昇
     */
    public int DamageUp = 3;

    public void SetJump(int x) {
        Jump = x;
    }
    public int GetJump() {
        return Jump;
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
