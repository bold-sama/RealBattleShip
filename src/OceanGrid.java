import java.awt.*;

public class OceanGrid extends TargetGrid {
    //constructor
    public OceanGrid(){
        //calls targetGrid constructor
        super();

    }
    //figure out direction of ship
    public Boolean placeShipAtPoints(){
        
    }

    public ShotResult receiveShot(Shot shot){
        Point affectedPoint = Shot.getLocation();
        Cell affectedCell = cellAtPoint(affectedPoint);
        CellState state = affectedCell.getState();
        if(state == CellState.OCCUPIED){
            affectedCell.setState(CellState.HIT);
            return ShotResult.HIT;
        }
    }
}
