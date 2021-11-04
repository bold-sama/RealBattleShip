import java.sql.Array;
import java.util.ArrayList;

public class Game {
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private int currentPlayerIndex = 0;

    public Game(){
        //Create two players
    String playerName = ConsoleHelper.getInput("enter your name");
    IPlayer player1 = new Humanplayer(playerName);
    players.add(player1);

    IPlayer player2 = new brodyAIPlayer();
    players.add(player2);
    }
    public void play(){
        for(IPlayer player : players){
            player.placeShip();
        }
        //start game
        while(true){
            //current player takes a shot
            IPlayer currentPlayer = players.get(currentPlayerIndex);
            System.out.printf("%n you're up, %s%n", currentPlayer.getName());
            Shot shot = currentPlayer.takeShot();
            System.out.printf("%s fires at %s", currentPlayer.getName(), shot.getDescription());
            //returning player gives result of shot
            IPlayer otherPlayer;
            if(currentPlayerIndex == 0){
                otherPlayer = players.get(1);
            } else {
                otherPlayer = players.get(0);
            }
            ShotResult result = otherPlayer.receiveShot(shot);
            switch(result){
                case HIT -> System.out.printf("--> HIT%n");

                case MISS -> System.out.printf("--> MISS%n");

                case HITANDSUNK -> System.out.printf("--> HIT and SUNK, you sunk my %S%n", result.getShipName());
            }
            currentPlayer.receiveShotResult(shot, result);

            //check for end of game
            if(otherPlayer.allShipsSunk()){
                System.out.printf("Game over!: the winner is --> %s%n", currentPlayer.getName());
                break;
            }

            //loop player index
            if(getCurrentPlayerIndex() == 0){
                currentPlayerIndex = 1;
            } else currentPlayerIndex = 0;
        }
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}
