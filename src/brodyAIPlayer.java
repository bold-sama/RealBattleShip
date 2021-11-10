import java.awt.*;
import java.util.*;

public class brodyAIPlayer extends Player {

    private ArrayList<Point> bracketShots = new ArrayList<Point>();

    public brodyAIPlayer(){
        super("USS Bold");
    }

    @Override
    public void placeShip() {
        placeShipsRandomly();
    }

    @Override
    public Shot takeShot(){
        return null;
    }

    @Override
    public ShotResult receiveShot(Shot shot) {
        return oceanGrid.receiveShot(shot);
    }
    @Override
    public void receiveShotResult(Shot shot, ShotResult result) {
        super.receiveShotResult(shot, result);
        if(result == ShotResult.MISS){
            //CurrentPhase.RANDOM
        }
    }
}
