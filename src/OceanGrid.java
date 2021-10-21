import java.awt.*;

public class OceanGrid extends TargetGrid {
    //constructor
    public OceanGrid(){
        //calls targetGrid constructor
        super();

    }
    //figure out direction of ship
    public Boolean placeShipAtPoint(Ship ship, Point[] points){
        if(pointsOutOfBounds(points)){
            return false;
        }
        if(pointsOverLapExistingShip(points)){
            return false;
        }
        for(Point point : points){
            Cell cell = cellAtPoint(point);
            cell.setState(CellState.OCCUPIED);
            cell.setShip(ship);
        }
        return true;
    }

    private Boolean pointsOverLapExistingShip(Point[] points){
        for(Point point : points){
            Cell cell = cellAtPoint(point);
            CellState state = cell.getState();
            if(state == CellState.OCCUPIED){
                return true;
            }
        }
        return false;
    }

    public Boolean pointsOutOfBounds(Point[] points){
        for(Point point : points){
            if(point.x < 0 || point.x > 9 || point.y < 0 || point.y > 9){
                return true;
            }
        }
        return false;
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
