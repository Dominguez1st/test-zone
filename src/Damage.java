import java.util.Arrays;

public class Damage {
  public static int [] stuff (int attackPower, int attackTypes){ // Attack types: Red = 1, Blue = 2, Green = 3
    AttackType[] types = valuesOfTypes(attackTypes);
    int[] info = new int[3];

    for (AttackType type : types) {
      int[] redInfo = calculateDamage(attackPower, type);
      info[0] += redInfo[0];
      info[1] += redInfo[1];
      info[2] += redInfo[2];
    }
    return info;
  }

  public static AttackType[] valuesOfTypes(int attackTypes){
    AttackType[] digits = new AttackType[3];
    for (int i = digits.length; i > 0;){
      digits [i - 1] = AttackType.values()[(attackTypes % 10)-1];
      attackTypes /= 10;
      i--;
    }
    return digits;
  }

  public static int[] calculateDamage (int attackPower, AttackType attackType){
    int[] info = new int[3];
    info[0] = (int) Math.round(attackPower * attackType.attackModifier * (Math.random()*.2 + .9));
    info[1] = (int) (Math.random() * attackType.manaGenerated) + 1;
    info[2] = (int) (Math.random() * attackType.criticalChance) + 1;
    return info;
  }

  enum AttackType {
    RED(1.5, 4, 6),
    BLUE( 1, 20, 6),
    GREEN( .8, 6, 20);

    private final double attackModifier;
    private final double manaGenerated;
    private final double criticalChance;

    AttackType(double attackModifier, double manaGenerated, double criticalChance) {
      this.attackModifier = attackModifier;
      this.manaGenerated = manaGenerated;
      this.criticalChance = criticalChance;
    }

    public double getAttackModifier() {
      return attackModifier;
    }

    public double getManaGenerated() {
      return manaGenerated;
    }

    public double getCriticalChance() {
      return criticalChance;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(stuff(100, 111)));
  }
}
