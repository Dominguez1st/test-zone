import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowManyNumbers {

  public static int selNumber(int n, int d) {

    List<Integer> acceptableNumbers = new ArrayList<>();
    for (int i = 12; i <= n; i++) {
      List<Integer> digits = convertDigitsToList(i);
      if (followsConstraints(digits, d)) {
        acceptableNumbers.add(i);
      }

    }
    return acceptableNumbers.size();
  }

  public static List<Integer> convertDigitsToList(int currentNumber) {
    List<Integer> singleNumbers = new ArrayList<>();
    for (int j = 0; currentNumber > 0; j++) {
      singleNumbers.add(currentNumber % 10);
      currentNumber = currentNumber / 10;
    }
    Collections.reverse(singleNumbers);
    return singleNumbers;
  }

  public static boolean followsConstraints(List<Integer> digits, int d) {
    for (int i = 0; i < digits.size() - 1; i++) {
      if (digits.get(i) >= digits.get(i + 1) || digits.get(i + 1) - digits.get(i) > d) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println(selNumber(1000, 1));
  }
}