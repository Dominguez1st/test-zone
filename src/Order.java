import java.util.ArrayList;
import java.util.List;

public class Order {
  public static String order(String words) {

    String[] individualWords = words.split(" ");
    List<String> correctOrder = new ArrayList<>();

    for (int i = 0; i <= individualWords.length; i++) {
      for (String word:individualWords) {
        if(word.contains( "" + i)){
          correctOrder.add(word);
        }
      }
    }
    return String.join(" ", correctOrder);
  }

  public static void main(String[] args) {
    System.out.println(order("is2 Thi1s T4est 3a"));
  }
}
