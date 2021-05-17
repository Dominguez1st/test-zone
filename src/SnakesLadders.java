import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SnakesLadders {
  private int[] playerPlacement;
  private boolean victory;
  private int turn;

  public SnakesLadders() {
    playerPlacement = new int[]{0,0};
    victory = false;
    turn = 1;
    Map<Integer, Integer> snakes = new HashMap<>();
    snakes.put(16,6);
  }
  public String play(int die1, int die2) {
    int currentPlayer = turn % 2;
    String currentName = "Player "+ (currentPlayer + 1);

    playerPlacement[currentPlayer] += die1 + die2;
    System.out.println(currentName+" rolled a "+die1+" and a "+die2+"."+currentName+" is on square "+playerPlacement[currentPlayer]+"." );
    if (playerPlacement[currentPlayer] > 100){ // Sets player 1 back if they went over 100
      playerPlacement[currentPlayer] = 100 - (playerPlacement[currentPlayer] - 100);
      System.out.println(currentName+" went over 100 and moved back to "+playerPlacement[currentPlayer]);
    }
    // map
    if (playerPlacement[currentPlayer] == 100){ // Ends the game.
      System.out.println(currentName+" Wins!");
      victory = true;
    }
    if (die1 != die2){ // Enables current player to goes again.
      turn++;
    }
    return currentName+" is on square "+ playerPlacement[currentPlayer];
  }

  public static void main(String[] args) {
    SnakesLadders game = new SnakesLadders();

    while (!game.victory){
      int die1 = ThreadLocalRandom.current().nextInt(1,6 + 1);
      int die2 = ThreadLocalRandom.current().nextInt(1,6 + 1);
      game.play(die1,die2);
    }
  }
}
