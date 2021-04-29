import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;

public class testZone {

  public static int[] oscillatingSquares(int length) {
    int[] oscillatedSquares;
    oscillatedSquares = new int[length];
    for (int i = 0; i < length; i++) {
      int square = i * i;
      if (i % 2 == 0) {
        square *= -1;
      }
      oscillatedSquares[i] = square;

    }
    System.out.println(Arrays.toString(oscillatedSquares));
    return oscillatedSquares;
  }

  public static boolean perfectCube(long input) {
    long cbrtInput = (long) Math.cbrt(input);
    boolean cube = cbrtInput * cbrtInput * cbrtInput == input;
    System.out.println(cube);
    return cube;
  }

  public static String stringProcessing(String input) {
    String newInput = input.toUpperCase();
    System.out.println(newInput);
    return newInput;
  }

  public static int[] signalProcessing(int[] input) {
    for (int i = 0; i < input.length - 1; i++) {
      input[i] = input[i + 1];
    }
    System.out.println(Arrays.toString(input));
    return input;
  }

  public static String[] buildFibonacciStaircase(int height) {
    String[] stairs = new String[height];
    int currentNum = 1;
    int previousNum = 0;
    for (int i = 0; i < height; i++) {
      int fib = currentNum + previousNum;
      previousNum = currentNum;
      currentNum = fib;
      System.out.println(fib);
      stairs[i] = " ".repeat(height - i) + "*".repeat(fib);
    }
    return stairs;
  }

  public static float clockAngleMinute(float input2) {
    return input2 * 6;
  }

  public static int clockAngleHour(int input, float input2) {
    float minuteDegree = clockAngleMinute(input2);
    int hour = input % 12;
    int hourDegree = (hour * 30) + ((int) minuteDegree / 12);
    return hourDegree;
  }

  public static String radix(long input, int radixPara) {
//    String done = Integer.toString((int)input, radixPara);
//    System.out.println(done);

    boolean isneg = input < 0;
    long num = Math.abs(input);

    String values = "0123456789abcdefghijklmnopqrstuvwxyz";
    int maxpos = 0;
    for (int i = 0; Math.pow(radixPara, i) < num; i++) {
      maxpos = i;
    }

    int[] numlist = new int[maxpos + 1];
    for (int pos = maxpos; pos >= 0; pos--) {
      int val = (int) num / maxpos;
      int remain = (int) num % maxpos;
      numlist[pos] = val;
      num = remain;
    }

    StringBuilder out = new StringBuilder();
    for (int n : numlist) {
      out.append(values.charAt(n));
    }
    return out.reverse().toString();
  }

  public static String substring(String input, int beginIndex, int endIndex) {
    if (beginIndex <= endIndex) {
      return input.substring(beginIndex, endIndex);
    } else {
      StringBuilder newInput = new StringBuilder();
      newInput.append(input);
      newInput = newInput.reverse();
      return newInput.substring(beginIndex, endIndex);
    }
  }

  public static int[] getCompetitionRanking(int[] leaderboard, int[] scores) {
    int[] myScore = new int[scores.length];
    for (int i = 0; i < scores.length; i++) {

      for (int j = 0; j < leaderboard.length; j++) {

        if (scores[i] >= leaderboard[j]) {
          myScore[i] = j + 1;
          break;
        } else {
          myScore[i] = leaderboard.length + 1;
        }
      }
    }
    return myScore;
  }

  public static int countEvens(int[] nums) {
    int counter = 0;
    for (int num : nums) {
      if (num % 2 == 0) {
        counter++;
      }
    }
    return counter;
  }

  public static int centeredAverage(int[] nums) {
    int min = 99999999;
    int max = -9999999;
    int sum = 0;
    for (int num : nums) {
      if (min >= num) {
        min = num;
      }
      if (max <= num) {
        max = num;
      }
      sum += num;
    }
    return (sum - (min + max)) / (nums.length - 2);
  }

  public int blackjack(int a, int b) {
    if (a > b && a <= 21) {
      return a;
    }
    if (b > a && b <= 21) {
      return b;
    }
    if (a > 21 && b > 21) {
      return 0;
    } else {
      return a <= b ? a : b;
    }
  }

  public boolean makeBricks(int small, int big, int goal) {
    if (((big * 5) + small) < goal) {
      return false;
    }
    if (goal - (5 * big) >= 0) {
      if ((goal - (5 * big)) - small <= 0) {
        return true;
      }
    }
    if (goal % 5 <= small) {
      return true;
    }
    return false;
  }

  public static int sumMultiples(int limitNum, int div1, int div2) {
    int div1Sum = 0;
    int div2Sum = 0;
    for (int i = 0; i < limitNum; i++) {
      if ((div1 * i) < limitNum) {
        div1Sum += div1 * i;
      }
      if ((div2 * i) < limitNum && i % div1 != 0) {
        div2Sum += div2 * i;
      }
    }
    return div1Sum + div2Sum;
  }

  public static boolean nugget(int chicken) {
    if (chicken == 0) {
      return true;
    }
    int mc = chicken - 6;
    if (mc % 6 == 0 || mc % 9 == 0 || mc % 20 == 0) {
      return nugget(mc);
    }
    mc = mc - 3;
    if (mc % 6 == 0 || mc % 9 == 0 || mc % 20 == 0) {
      return nugget(mc);
    }
    mc = mc - 11;
    if (mc % 6 == 0 || mc % 9 == 0 || mc % 20 == 0) {
      return nugget(mc);
    }
    return false;
  }

  public static boolean isMcNuggetNumber(int target) {
    if (target > 0) {
      return nugget(target);
    }
    return false;
  }

  public static boolean isValid(String digits) throws IllegalArgumentException {
    long sum = 0;
    ;
    long count = 0;
    for (int i = 0; i < digits.length(); i++) {
      count += 1;
      if (count % 2 != 0) {
        sum += sum;
      } else {
        int temp = 2 * digits.indexOf(i);
        if (temp > 9) {
          temp -= 9;
        }
        sum += temp;
      }
    }
    return sum % 10 == 0;
  }

  public static long nextPerfectSquare(long input) {
    long nextSquare = 0;
    if (input == Math.sqrt(input * input)) {
      nextSquare = (long) (Math.sqrt(input) + 1);
    }
    return nextSquare * nextSquare;
  }

  public static int[] signalProcessingTwo(int[] input) {
    return input;
  }

  public static String complementaryDNA(String input) {
    String newString = input.replace('A', '♣');
    newString = newString.replace('T', 'A');
    newString = newString.replace('♣', 'T');
    newString = newString.replace('C', '♣');
    newString = newString.replace('G', 'C');
    newString = newString.replace('♣', 'G');
    return newString;
  }

  public static long greatestCommonDivisor(long input1, long input2) {
    long lower = Math.min(input1, input2);
    long higher = Math.max(input1, input2);
    higher = higher - lower;
    if (higher == lower) {
      return lower;
    }
    return greatestCommonDivisor(lower, higher);
  }

  public static String stringSlicing(String input) {
    int beginIndex = 1;
    int endIndex = 8;
    int stride = 2;
    String sliced = "";
    String test = input.substring(beginIndex, endIndex);
    for (int i = 0; i < test.length(); i += stride) {
      sliced += test.charAt(i);
    }
    return sliced;
  }

  public static float clockAngles(int hour, float minutes) {
    double hourOffset = (hour + 9) % 12;
    double minutesDegree = minutes * 6;
    double hourDegree = (hourOffset * 30) + minutesDegree / 12;
    double inverseDegree = 360 - hourDegree;
    float radianHour = (float) (inverseDegree * (Math.PI / 180));
    return radianHour;
  }

  public static String ssnFormatter(int[] input) {
    String ssnString = Arrays.toString(input);
    String regex = "[, \\] \\[]";
    ssnString = ssnString.replaceAll(regex, "");
    StringBuilder builder = new StringBuilder(ssnString);
    builder.insert(3, "-").insert(6, "-");
    return builder.toString();
  }

  public static int[] ssnFormatter(String input) {
    String[] ssn = input.split("-");
    int[] ssnInts = new int[ssn.length];

    for (int i = 0; i < ssn.length; i++) {
      ssnInts[i] = Integer.parseInt(ssn[i]);
    }
    return ssnInts;
  }

  public static int[] reverse(int[] input) {
    int[] reversed = new int[input.length];
    for (int i = 0; i < input.length - 1; i++) {
      reversed[(input.length - 1) - i] = input[i];
    }
    return reversed;
  }

  private static int initialize(int value) {
    System.out.println("initialize");
    return value;
  }

  private static boolean test(int value) {
    System.out.println("test");
    return value > 0;
  }

  private static int reduce(int value) {
    System.out.println("reduce");
    return value /= 2;
  }

  private static String DuplicateEncoder(String word) {
    word = word.toLowerCase();
    String encode = "";
    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j < word.length(); j++) {

        if (word.charAt(i) == word.charAt(j) && i != j) {
          encode += ")";
          break;
        }
        if (j == word.length() - 1) {
          encode += "(";
          break;
        }
      }
    }
    System.out.println(encode);
    return encode;
  }

  public static String highAndLow(String numbers) {
    String test = "";
    String[] strArray = numbers.split(" ");
    int[] intArray = new int[strArray.length];
    for (int i = 0; i < strArray.length; i++) {
      intArray[i] = Integer.parseInt(strArray[i]);
    }

    test += Arrays.stream(intArray).max().getAsInt();
    test += " ";
    test += Arrays.stream(intArray).min().getAsInt();

    System.out.print(test);
    return test;
  }

  public static String Tickets(int[] peopleInLine) {
    int jacksonCounter = 0;
    int grantCounter = 0;
    int benCounter = 0;

    for (int bill : peopleInLine) {
      if (bill == 25) {
        jacksonCounter += 1;
      } else if (bill == 50 && jacksonCounter > 0) {
        jacksonCounter -= 1;
        grantCounter += 1;
      } else if (bill == 100 && jacksonCounter > 0 && grantCounter > 0) {
        jacksonCounter -= 1;
        grantCounter -= 1;
        benCounter += 1;
      } else if (bill == 100 && jacksonCounter >= 3 && grantCounter < 0) {
        jacksonCounter -= 3;
        benCounter += 1;
      } else {
        return "NO";
      }
    }
    return "YES";
  }

  public static String SongDecoder(String song) {
    String wub = " " + "WUB" + " ";
    song = song.replaceAll(wub, "");
    return song;
  }

  public static String seriesSum(int n) {
    double value = 0;
    double divisor = 1;

    for (int i = 0; i < n; i++, divisor += 3) {
      value += 1 / divisor;
    }
    return String.format("%.2f", value);
  }

  public static int ConvertBinaryArrayToInt(List<Integer> binary) {
    int biNum = 0;
    String decNum;

    for (Integer integer : binary) {
      biNum = 10 * biNum + integer;
    }
    decNum = String.valueOf(biNum);

    return Integer.parseInt(decNum, 2);
  }

  public static String camelCase(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (Character.isUpperCase(input.charAt(i))) {
        input = new StringBuilder(input).insert(i, " ").toString();
        i += 1;
        System.out.println(input);
      }
    }
    System.out.println(input);
    return input;
  }

  public static String[] capitalize(String s) {
    String firstCapital = "";
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        firstCapital += s.substring(i, i + 1).toUpperCase();
      } else {
        firstCapital += s.substring(i, i + 1);
      }
    }
    System.out.println(firstCapital);

    String secondCapital = "";
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 != 0) {
        secondCapital += s.substring(i, i + 1).toUpperCase();
      } else {
        secondCapital += s.substring(i, i + 1);
      }
    }
    System.out.println(secondCapital);

    String[] twoAlternatingCaps = {firstCapital, secondCapital};
    return twoAlternatingCaps;
  }

  public static String disemvowel(String str) {
    // Code away...
    return str.replaceAll("e", "");
  }

  public static String whoLikesIt(String... names) {
    if (names.length == 0) {
      System.out.println("no one likes this");
      return "no one likes this";
    } else if (names.length == 1) {
      System.out.println(names[0] + " likes this");
      return (names[0] + " likes this");
    } else if (names.length == 2) {
      System.out.println(names[0] + " and " + names[1] + " like this");
      return (names[0] + " and " + names[1] + " like this");
    } else if (names.length == 3) {
      System.out.println(names[0] + ", " + names[1] + " and " + names[2] + " like this");
      return (names[0] + ", " + names[1] + " and " + names[2] + " like this");
    } else {
      System.out
          .println(names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this");
      return (names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this");
    }
  }

  public static String JadenCase(String phrase) {
    if (phrase == null) {
      return null;
    }
    if (phrase.equals("")) {
      return null;
    }
    String[] arr = phrase.split(" ");
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < arr.length; i++) {
      sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
    }
    System.out.println(sb.toString().trim());
    return sb.toString().trim();
  }

  public static String accum(String s) {
    String output = "";

    for (int i = 0; i < s.length(); i++) {
      output = output + s.toUpperCase().charAt(i);
      for (int j = 0; j < i; j++) {
        output = output + s.toLowerCase().charAt(i);
      }
      output = output + "-";
    }

    System.out.println(output.substring(0, output.length() - 1));
    return output.substring(0, output.length() - 1);
  }

  public static String encryptThis(String text) {
    if (text.equals("")) {
      return "";
    }
    String[] textWords = text.split(" ");
    String[] newTextWords = new String[textWords.length];
    for (int i = 0; i < textWords.length; i++) {
      int ascii = textWords[i].charAt(0);
      if (textWords[i].length() > 2) {
        char[] swapper = textWords[i].toCharArray();
        char temp = swapper[1];
        swapper[1] = swapper[swapper.length - 1];
        swapper[swapper.length - 1] = temp;
        textWords[i] = new String(swapper);
      }
      String newWord = ascii + textWords[i].substring(1);
      newTextWords[i] = newWord;
    }
    return String.join(" ", newTextWords);
  }

  public static int countSmileys(List<String> arr) {
    int smileyCount = 0;
    for (String face : arr) {
      char[] facialFeatures = face.toCharArray();
      if ((facialFeatures.length == 2) && ((facialFeatures[0] == ':' || facialFeatures[0] == ';')
          && (facialFeatures[1] == ')' || facialFeatures[1] == 'D'))) {
        smileyCount += 1;
      }
      if ((facialFeatures.length == 3) && (facialFeatures[0] == ':' || facialFeatures[0] == ';')
          && (facialFeatures[1] == '-' || facialFeatures[1] == '~') && (facialFeatures[2] == ')'
          || facialFeatures[2] == 'D')) {
        smileyCount += 1;
      }
    }
    return smileyCount;
  }

  public static double findUniq(double arr[])   {
    double unique = 0;
    for (int i = 0; i < arr.length; i++) {
      int j;
      for (j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          break;
        }
      }
      if (i == j) {
        unique = arr[i];
      }
    }
    if (arr[0] != arr[1] && arr[arr.length-1] == arr[1]){
      return arr[0];
    }
    return unique;
  }


  public static void main(String[] args) {
    encryptThis("A wise old owl lived in an oak");
  }
}

