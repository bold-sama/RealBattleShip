import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ship {
    private String name;
    private int length;

    //creating ship dictionary
    public static final Map<String, Integer> shipDefinitions;

    static {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("Destroyer", 2);
        myMap.put("Submarine", 3);
        myMap.put("Cruiser", 3);
        myMap.put("Battleship", 4);
        myMap.put("Carrier", 5);
        shipDefinitions = Collections.unmodifiableMap(myMap);
    }

    public Ship(String name, int length){
        this.name = name;
        this.length = length;
    }
}
