import java.util.ArrayList;
import java.util.Map.Entry;
import java.awt.Point;

public abstract class Player implements IPlayer {
    protected String name;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
    protected ArrayList<Ship> ships = new ArrayList<Ship>();

    public Player(String name) {
        this.name = name;
        for (Entry<String, Integer> item : Ship.shipDefinitions.entrySet()) {
            Ship newShip = new Ship(item.getKey(), item.getValue());
            ships.add(newShip);
        }
    }

    public String getName() {
        return name;
    }

    public abstract Shot takeShot();

    public abstract ShotResult receiveShot(Shot shot);

    public abstract void placeShip();

    //picks start point for ship
    private Point randomPositionOnGrid() {
        int x = (int) (Math.random() * 10.0);
        int y = (int) (Math.random() * 10.0);
        return new Point(x, y);
    }

    public Point[] placement(int length, Point start, Direction direction) {
        Point[] points = new Point[length];
        points[0] = start;
        for (int i = 1; i < length; i++) {
            int nextX = points[i - 1].x;
            int nextY = points[i - 1].y;
            switch (direction) {
                case NORTH -> nextY -= 1;
                case SOUTH -> nextY += 1;
                case EAST -> nextX += 1;
                case WEST -> nextX -= 1;
            }
            points[i] = new Point(nextX, nextY);
        }
        return points;
    }

    public void receiveShotResult(Shot shot, ShotResult result) {
        switch (result) {
            case HIT, HITANDSUNK -> targetGrid.noteHit(shot);
            case MISS -> targetGrid.noteMiss(shot);
        }
    }

    public Boolean allShipsSunk() {
        for (Ship ships : ships) {
            if (!ships.beenSunk()) {
                return false;
            }
        }
        return true;
    }

    protected void placeShipsRandomly() {
        for (Ship ship : ships) {
            while (true) {
                //origin point of ship
                Point startPoint = randomPositionOnGrid();
                //ship direction
                Direction dir = Direction.randomDirection();
                //place ship with direction
                Point[] shipPoints = placement(ship.getLength(), startPoint, dir);
                boolean result = oceanGrid.placeShipAtPoint(ship, shipPoints);
                if (result) {
                    break;
                }
            }
        }
    }
}