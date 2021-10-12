import java.util.ArrayList;

public class Player {
    private String name;
    private OceanGrid oceanGrid = new OceanGrid();
    private TargetGrid targetGrid = new TargetGrid();
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public Player(String name){
        this.name = name;
    }

    public void placeShip(){

    }
}
