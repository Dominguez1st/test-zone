import java.util.List;

public class HowManyNumbers {

  public static List<Long> findAll(final int sumDigits, final int numDigits) {
    StringBuilder stringNumber = new StringBuilder().append("1");
    long number = 0;
    long counter = 0;
    int [] singleNumbers = new int[numDigits];
    boolean ascending = true;

    for (int i = 1; i < numDigits; i++){
      stringNumber.append("0");
    }
    int startingNumber = Integer.parseInt(stringNumber.toString());
    int endNumber = Integer.parseInt(stringNumber.append("0").toString()) - 1;

    while (startingNumber < endNumber){
      int tempNumber = startingNumber;
      for (int j = 0; tempNumber > 0; j++){
        number += tempNumber % 10;
        singleNumbers[j] = tempNumber % 10;
        tempNumber = tempNumber / 10;
      }
      for (int k = 0; k < singleNumbers.length - 1; k++){
        if (singleNumbers[k] < singleNumbers[k+1]){
         ascending = false;
        }
      }
      if(number == sumDigits && ascending == false) {
        counter++;
        System.out.println(startingNumber);
      }
      number = 0;
      startingNumber++;
    }

    System.out.println(startingNumber);
    System.out.println(endNumber);
    System.out.println(counter);

    return null;
  }

  public static void main(String[] args) {
    findAll(10, 3);
  }

}
