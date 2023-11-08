import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class CarTest {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95();
    }

    @Test
    public void testTurnLeft(){
        String oldDirection = saab.getDirection();
        saab.turnLeft();
        String newDirection = saab.getDirection();

        switch(oldDirection){
            case "North":
                assertEquals("Direction check", newDirection, "West");
                break;
            case "East":
                assertEquals("Direction check", newDirection, "North");
                break;
            case "South":
                assertEquals("Direction check", newDirection, "East");
                break;
            case "West":
                assertEquals("Direction check", newDirection, "South");
                break;
        }
    }

    @Test
    public void testTurnRight(){
        String oldDirection = saab.getDirection();
        saab.turnRight();
        String newDirection = saab.getDirection();

        switch(oldDirection){
            case "North":
                assertEquals("Direction check", newDirection, "East");
                break;
            case "East":
                assertEquals("Direction check", newDirection, "South");
                break;
            case "South":
                assertEquals("Direction check", newDirection, "West");
                break;
            case "West":
                assertEquals("Direction check", newDirection, "North");
                break;
        }
    }

}
