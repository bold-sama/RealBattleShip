import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.awt.*;
public class playerTests {
    private Player player;

    @Before
    public void init() {
        player = new Player("Test Player1");
    }

    @Test
    public void testNorthShip(){
        Point startPoint = new Point(2,3);
        Point[] values = player.placement(4, startPoint, Direction.NORTH);
        Point[] result = {new Point(2,3), new Point(2,2),new Point(2,1),new Point(2,0)};
        assertArrayEquals(values, result);
    }
}
