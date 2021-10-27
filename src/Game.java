import java.sql.Array;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int currentPlayerIndex = 0;

    public Game(){
        //Create two players
    String playerName = ConsoleHelper.getInput("enter the name of player one");
    Player player1 = new Player(playerName);
    players.add(player1);

    playerName = ConsoleHelper.getInput("enter the name of player two");
    Player player2 = new Player(playerName);
    players.add(player2);
    }
    public void play(){
        for(Player player: players){
            player.placeShip();
        }
        //start game
        while(true){
            //current player takes a shot
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.printf("%n you're up, %s%n", currentPlayer.getName());
            Shot shot = currentPlayer.takeShot();
            System.out.printf("%s fires at %s", currentPlayer.getName(), shot.getDescription());
            //returning player gives result of shot
            Player otherPlayer;
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
            if(currentPlayerIndex == 0){
                currentPlayerIndex = 1;
            } else currentPlayerIndex = 0;
        }
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}
