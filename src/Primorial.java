import java.math.BigDecimal;

public class Primorial {
  public static String numPrimorial(int n) {
    int counter = 0;
    BigDecimal answer = BigDecimal.ONE;
    for ( int i = 0; counter < n; i++){
      if (isPrime(i)){
        answer = answer.multiply(BigDecimal.valueOf(i));
        counter++;
      }
    }
    System.out.println(answer);
    return "" + answer;
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    numPrimorial(5);
  }
}