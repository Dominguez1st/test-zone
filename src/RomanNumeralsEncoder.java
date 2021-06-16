public class RomanNumeralsEncoder {

  public static String solution(int n) {
    StringBuilder Numerals = new StringBuilder();

    while (n >= 1000){
      Numerals.append("M");
      n -= 1000;
    }
    while (n >= 900){
      Numerals.append("CM");
      n -= 900;
    }
    while (n >= 500){
      Numerals.append("D");
      n -= 500;
    }
    while (n >= 400){
      Numerals.append("CD");
      n -= 400;
    }
    while (n >= 100){
      Numerals.append("C");
      n -= 100;
    }
    while (n >= 90){
      Numerals.append("XC");
      n -= 90;
    }
    while (n >= 50){
      Numerals.append("L");
      n -= 50;
    }
    while (n >= 40){
      Numerals.append("XL");
      n -= 40;
    }
    while (n >= 10){
      Numerals.append("X");
      n -= 10;
    }
    while (n >= 9){
      Numerals.append("IX");
      n -= 9;
    }
    while (n >= 5){
      Numerals.append("V");
      n -= 5;
    }
    while (n >= 4){
      Numerals.append("IV");
      n -= 4;
    }
    while (n >= 1){
      Numerals.append("I");
      n -= 1;
    }
    return Numerals.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution(3624));
  }
}
