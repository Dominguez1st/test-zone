import java.util.Arrays;

public class Damage {
  public static int [] stuff (int attackPower, int attackTypes){ // Attack types: Red = 1, Blue = 2, Green = 3
    int[] types = valuesOfTypes(attackTypes);
    int[] info = new int[3];

    for (int attack : types) {
      if (attack == 1){
        int[] redInfo = redDamage(attackPower);
        info[0] += redInfo[0];
        info[1] += redInfo[1];
        info[2] += redInfo[2];
      }
      if (attack == 2){
        int[] blueInfo = blueDamage(attackPower);
        info[0] += blueInfo[0];
        info[1] += blueInfo[1];
        info[2] += blueInfo[2];
      }
      if (attack == 3){
        int[] greenInfo = greenDamage(attackPower);
        info[0] += greenInfo[0];
        info[1] += greenInfo[1];
        info[2] += greenInfo[2];
      }
    }
    return info;
  }

  public static int [] valuesOfTypes(int attackTypes){
    int[] digits = new int[3];
    for (int i = digits.length; i > 0;){
      digits [i - 1] = attackTypes % 10;
      attackTypes /= 10;
      i--;
    }
    return digits;
  }

  public static int[] redDamage (int attackPower){
    int[] info = new int[3];
    info[0] = (int) (attackPower * 1.5);
    info[1] = (int) (Math.random() * 4) + 1;
    info[2] = (int) (Math.random() * 6) + 1;
    return info;
  }

  public static int[] blueDamage (int attackPower){
    int[] info = new int[3];
    info[0] = attackPower;
    info[1] = (int) (Math.random() * 20) + 1;
    info[2] = (int) (Math.random() * 6) + 1;
    return info;
  }

  public static int[] greenDamage (int attackPower){
    int[] info = new int[3];
    info[0] = (int) (attackPower * .8);
    info[1] = (int) (Math.random() * 6) + 1;
    info[2] = (int) (Math.random() * 10) + 1;
    return info;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(stuff(20, 123)));
  }
}
