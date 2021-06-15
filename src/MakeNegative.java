public class MakeNegative {

  public static int makeNegative(final int x) {
    return (x > 0) ? (x * -1):(x);
  }

  public static void main(String[] args) {
    System.out.println(makeNegative(1000));
  }
}
