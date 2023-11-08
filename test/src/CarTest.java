import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CarTest {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95();
    }

    @Test
    public void testTurnLeftFromSouth(){
        saab.setDirection("South");
        saab.turnLeft();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "East");
    }

    @Test
    public void testTurnLeftFromWest(){
        saab.setDirection("West");
        saab.turnLeft();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "South");
    }
    @Test
    public void testTurnLeftFromEast(){
        saab.setDirection("East");
        saab.turnLeft();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "North");
    }

    @Test
    public void testTurnLeftFromNorth(){
        saab.setDirection("North");
        saab.turnLeft();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be East", newDirection, "West");
    }
    @Test
    public void testTurnRightFromSouth(){
        saab.setDirection("East");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "South");
    }

    @Test
    public void testTurnRightFromWest(){
        saab.setDirection("East");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "South");
    }
    @Test
    public void testTurnRightFromEast(){
        saab.setDirection("East");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "South");
    }

    @Test
    public void testTurnRightFromNorth(){
        saab.setDirection("North");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be East", newDirection, "East");
    }

    @Test
    public void testMove() {
        double oldPosition;
        double newPosition;
        double currentSpeed = saab.getCurrentSpeed();
        String direction = saab.getDirection();

        if (direction.equals("North") || direction.equals("South")){
            oldPosition = saab.getYPosition();
            saab.move();
            newPosition = saab.getYPosition();

        } else {
            oldPosition = saab.getXPosition();
            saab.move();
            newPosition = saab.getXPosition();
        }

        if (direction.equals("North") || direction.equals("East")){
            assertTrue("move check", (oldPosition + currentSpeed) == newPosition);
        } else {
            assertTrue("move check", (oldPosition - currentSpeed) == newPosition);
        }
    }

    @Test
    public void testGas(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(2);
        double currentSpeed = saab.getCurrentSpeed();
        assertTrue("test gas", oldSpeed < currentSpeed);
    }

    @Test
    public void testBrake(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(2);
        double currentSpeed = saab.getCurrentSpeed();
        assertTrue("test gas", oldSpeed > currentSpeed);
    }

}
