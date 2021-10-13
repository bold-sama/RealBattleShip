import java.util.ArrayList;
import java.awt.Point;

public class Player {
    private String name;
    private OceanGrid oceanGrid = new OceanGrid();
    private TargetGrid targetGrid = new TargetGrid();
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public Player(String name){
        this.name = name;
    }

    public void placeShip(){
        for(Ship ship : ships){
            //origin point of ship
            Point.startPoint = randomPositionOnGrid();
            //ship direction
            Direction dir = Direction.randomDirection();
            //place ship
            Point[] shipPoints = placement(ship.getLength(), startPoint, dir);
        }
    }

    //picks start point for ship
    private Point randomPositionOnGrid(){
        int x = (int)(Math.random()*10.0);
        int y = (int)(Math.random()*10.0);
        return new Point(x, y);
    }

    private Point[] placement(int length, Point start, Direction direction){
        Point[] points = new Point(length);
        points[0] = start;
        return points;
    }
}
