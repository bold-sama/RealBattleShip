import java.util.ArrayList;
import java.util.Map.Entry;
import java.awt.Point;

public class Player {
    private String name;
    private OceanGrid oceanGrid = new OceanGrid();
    private TargetGrid targetGrid = new TargetGrid();
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public Player(String name){
        this.name = name;
        for(Entry<String,Integer> item : Ship.shipDefinitions.entrySet()){
            Ship newShip = new Ship(item.getKey(), item.getValue());
            ships.add(newShip);
        }
    }
    public String getName() {
        return name;
    }

    public void placeShip(){
        for(Ship ship : ships){
            while(true){
                //origin point of ship
                Point startPoint = randomPositionOnGrid();
                //ship direction
                Direction dir = Direction.randomDirection();
                //place ship with direction
                Point[] shipPoints = placement(ship.getLength(), startPoint, dir);
                boolean result = oceanGrid.placeShipAtPoint(ship, shipPoints);
                if(result){
                    break;
                }
            }
        }
    }
        //picks start point for ship
    private Point randomPositionOnGrid(){
        int x = (int)(Math.random()*10.0);
        int y = (int)(Math.random()*10.0);
        return new Point(x, y);
    }


    public Point[] placement(int length, Point start, Direction direction){
        Point[] points = new Point[length];
        points[0] = start;
        for(int i = 1; i < length; i++){
            int nextX = (int) points[i-1].x;
            int nextY = (int) points[i-1].y;
            switch(direction){
                case NORTH -> nextY -= 1;
                case SOUTH -> nextY += 1;
                case EAST -> nextX += 1;
                case WEST -> nextX -= 1;
            }
            points[i] = new Point(nextX,nextY);
        }
        return points;
    }

    public Shot takeShot(){
        targetGrid.description();
        oceanGrid.description();
        //create local shot from user
        Shot shot = null;
        while(true){
            String input = ConsoleHelper.getInput("enter shot");
            try{
                shot = new Shot(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            //no duplicate shots. can not take a shot that's been taken
            if(targetGrid.shotHasNotBeenMadeYet(shot)){
                break;
            } else {
                System.out.printf("you have already taken a shot at %s%n",input);
            }
        } return shot;
    }
    public void receiveShotResult(Shot shot, ShotResult result){
        switch(result){
            case HIT, HITANDSUNK -> targetGrid.noteHit(shot);
            case MISS -> targetGrid.noteMiss(shot);
        }
    }

    public Boolean allShipsSunk(){
        for(Ship ships : ships){
           if (!ships.beenSunk()){
               return false;
           }
        }
        return true;
    }

    public ShotResult receiveShot(Shot shot){
        return oceanGrid.receiveShot(shot);
    }
}
