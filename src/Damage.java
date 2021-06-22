import java.util.Arrays;

public class Damage {
  public static int stuff (int attackPower, int attackTypes){
    String[] colors = {"RED", "GREEN", "BLUE"};



    return 0;
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
    info[1] = (int) (Math.random() * 6 +1);
    info[2] = (int) (Math.random() * 6) + 1;

    return info;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(redDamage(20)));
  }
}
