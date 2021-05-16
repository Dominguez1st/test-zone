import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HowManyNumbers {

  public static List<Long> findAll(final int sumDigits, final int numDigits) {
    long min = 0;
    long max = 0;
    long counter = 0;

    long startingNumber = calculateStartingNumber(numDigits);
    long endNumber = calculateEndNumber(numDigits);

    for (long i = startingNumber; i <= endNumber; i = nextNumber(i,numDigits)){
      List<Integer> digits = convertDigitsToArray(i,numDigits);

      if(isDigitsEqualSum(digits, sumDigits)) {
        counter++;
        if (min == 0){
          min = i;
        }
        max = i;
      }
    }

    if (counter == 0) return Collections.emptyList();
    return Arrays.asList(counter, min, max);
  }
  public static long nextNumber (long currentNumber, int numDigits){
    StringBuilder current = new StringBuilder();
    currentNumber += 1;
    List<Integer> digits = convertDigitsToArray(currentNumber, numDigits);
    for (int i = digits.size() - 1; i >= 0; i--){
      if (digits.get(i) == 0){
        digits.set(i,digits.get(i+1));
      }
      current.append(digits.get(i));
    }
    return Long.parseLong(String.valueOf(current));
  }

  public static long calculateStartingNumber (int numDigits) {
    return Long.parseLong("1".repeat(numDigits));
  }

  public static long calculateEndNumber (int numDigits){
    return (long) Math.pow(10, numDigits) -1;
  }

  public static List<Integer> convertDigitsToArray (long currentNumber, int numDigits){
    List<Integer> singleNumbers = new ArrayList<>(numDigits);
    for (int j = 0; currentNumber > 0; j++){
      singleNumbers.add((int) (currentNumber % 10));
      currentNumber = currentNumber / 10;
    }
    return singleNumbers;
  }

  public static boolean isDigitsEqualSum (List<Integer> digits, int sumDigits){
    int total = 0;
    for (int digit : digits) {
      total += digit;
    }
    return total == sumDigits;
  }

  public static boolean isAscending (int[]digits){
    for (int i = 0; i < digits.length - 1; i++){
      if (digits[i] < digits[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(findAll(10, 3));
  }
}
