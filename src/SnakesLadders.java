import java.util.concurrent.ThreadLocalRandom;

public class SnakesLadders {
  public SnakesLadders() {
    boolean victory = false;
    String currentPlayer = "";
    int playerOnePlacement = 0;
    int playerTwoPlacement = 0;
    for (int i = 1; !victory; i++){
      if (i % 2 != 0){ // Determines whose turn it is.
        currentPlayer = "Player 1";
      } else {
        currentPlayer = "Player 2";
      }
      int die1 = ThreadLocalRandom.current().nextInt(1,6 + 1);
      int die2 = ThreadLocalRandom.current().nextInt(1,6 + 1);
      if (currentPlayer.equals("Player 1")){ // Keeps track of player 1's position
        playerOnePlacement += die1 + die2;
        System.out.println(currentPlayer+" rolled a "+die1+" and a "+die2+"."+currentPlayer+" is on square "+playerOnePlacement+"." );
      } else { // Keeps track of player 2's position
        playerTwoPlacement += die1 + die2;
        System.out.println(currentPlayer+" rolled a "+die1+" and a "+die2+"."+currentPlayer+" is on square "+playerTwoPlacement+"." );
      }
      if (playerOnePlacement > 100){ // Sets player 1 back if they went over 100
        playerOnePlacement = 100 - (playerOnePlacement - 100);
        System.out.println(currentPlayer+" went over 100 and moved back to "+playerOnePlacement);
      }
      if (playerTwoPlacement > 100){ // Sets player 2 back if they went over 100
        playerTwoPlacement = 100 - (playerTwoPlacement - 100);
        System.out.println(currentPlayer+" went over 100 and moved back to "+playerTwoPlacement);
      }
      if (playerOnePlacement == 100 || playerTwoPlacement == 100){ // Ends the game.
        System.out.println(currentPlayer+" Wins!");
       victory = true;
      }
      if (die1 == die2){ // Enables current player to goes again.
        i--;
      }
    }
  }
  public String play(int die1, int die2) {
    return "";
  }

  public static void main(String[] args) {
    new SnakesLadders();
  }
}
