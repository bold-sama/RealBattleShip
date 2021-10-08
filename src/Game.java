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

    playerName = ConsoleHelper.getInput("enter the name of player one");
    Player player2 = new Player(playerName);
    players.add(player2);
    }
}
