import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SnakesLadders {
  private int[] playerPlacement;
  private boolean victory;
  private int turn;
  private Map<Integer, Integer> snakesAndLadders;

  public SnakesLadders() {
    playerPlacement = new int[]{0,0};
    victory = false;
    turn = 0;
    snakesAndLadders = new HashMap<>();
    //snakes
    snakesAndLadders.put(16,6);
    snakesAndLadders.put(46,25);
    snakesAndLadders.put(49,11);
    snakesAndLadders.put(62,19);
    snakesAndLadders.put(64,60);
    snakesAndLadders.put(74,53);
    snakesAndLadders.put(89,68);
    snakesAndLadders.put(92,88);
    snakesAndLadders.put(95,75);
    snakesAndLadders.put(99,80);
    //ladders
    snakesAndLadders.put(2,38);
    snakesAndLadders.put(7,14);
    snakesAndLadders.put(8,31);
    snakesAndLadders.put(15,26);
    snakesAndLadders.put(21,42);
    snakesAndLadders.put(28,84);
    snakesAndLadders.put(36,44);
    snakesAndLadders.put(51,67);
    snakesAndLadders.put(71,91);
    snakesAndLadders.put(78,98);
    snakesAndLadders.put(87,84);
  }
  public String play(int die1, int die2) {
    int currentPlayer = turn % 2;
    String currentName = "Player "+ (currentPlayer + 1);
    if(victory){
      return "Game over!";
    }
    playerPlacement[currentPlayer] += die1 + die2;
    System.out.println(currentName+" rolled a "+die1+" and a "+die2+". "+currentName+" is on square "+playerPlacement[currentPlayer]+"." );
    if (playerPlacement[currentPlayer] > 100){ // Sets player 1 back if they went over 100
      playerPlacement[currentPlayer] = 100 - (playerPlacement[currentPlayer] - 100);
      System.out.println(currentName+" went over 100 and moved back to "+playerPlacement[currentPlayer]);
    }
    if (snakesAndLadders.containsKey(playerPlacement[currentPlayer])) {
      System.out.print(currentName+" has moved from "+playerPlacement[currentPlayer]+" to ");
      playerPlacement[currentPlayer] = snakesAndLadders.get(playerPlacement[currentPlayer]);
      System.out.println(playerPlacement[currentPlayer]);
    }
    if (playerPlacement[currentPlayer] == 100){ // Ends the game.
      System.out.println(currentName+" Wins!");
      victory = true;
      return currentName+" Wins!";
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
