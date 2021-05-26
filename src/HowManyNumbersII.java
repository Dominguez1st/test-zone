import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowManyNumbersII {
  public static long[] maxSumDig(long nmax, int maxsm) {
    System.out.println("-------------------");
    System.out.println("nmax: "+nmax+" maxsm:"+maxsm);
    List<Long> acceptableNumbers = new ArrayList<>();
    long totalSum = 0;
    for (int i = 1000; i <= nmax; i++){
      List<Integer> digits = convertDigitsToList(i);
      if (isSumGreaterThanLimit(digits, maxsm)){
        System.out.println(i);
        acceptableNumbers.add((long) i);
        totalSum += i;
      }
    }
    System.out.println("The mean: " + totalSum/acceptableNumbers.size());
    return new long[]{acceptableNumbers.size(),theMeanReversed(acceptableNumbers,totalSum),totalSum};
  }

  public static List<Integer> convertDigitsToList(int currentNumber) {
    List<Integer> singleNumbers = new ArrayList<>();
    for (int j = 0; currentNumber > 0;) {
      singleNumbers.add(currentNumber % 10);
      currentNumber = currentNumber / 10;
    }
    Collections.reverse(singleNumbers);
    return singleNumbers;
  }

  public static boolean isSumGreaterThanLimit (List<Integer> digits, int maxsm){
    for (int i = 0; i < digits.size() - 3; i++){
      if (digits.get(i) + digits.get(i+1) + digits.get(i+2) +digits.get(i+3) > maxsm){
        return false;
      }
    }
    return true;
  }

  public static long theMean (List<Long> acceptableNumbers, long totalSum){
    long mean = totalSum/acceptableNumbers.size();
    long distance = Math.abs(acceptableNumbers.get(0) - mean);
    long idx = 0;
    for (int i = 1; i < acceptableNumbers.size(); i++){
      long cDistance = Math.abs(acceptableNumbers.get(i) - mean);
      if (cDistance == distance){

      } else if (cDistance < distance){
        idx = i;
        distance = cDistance;
      }
    }
    return acceptableNumbers.get((int) idx);
  }

  public static long theMeanReversed (List<Long> acceptableNumbers, long totalSum){
    long mean = totalSum/acceptableNumbers.size();
    long distance = Math.abs(acceptableNumbers.get(acceptableNumbers.size() - 1) - mean);
    long idx = 0;
    for (int i = acceptableNumbers.size() - 2; i > 0; i--){
      long cDistance = Math.abs(acceptableNumbers.get(i) - mean);
      if (cDistance == distance){

      } else if (cDistance < distance){
        idx = i;
        distance = cDistance;
      }
    }
    return acceptableNumbers.get((int) idx);
  }

  public static void main(String[] args) {
    System.out.println(maxSumDig(5000, 6));
  }

}
