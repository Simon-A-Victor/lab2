import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.awt.*;

public class CarTest {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95();
    }

    @Test
    public void testGetNumberOfDoors(){
        assertEquals("Number of doors should be 2", saab.getNrDoors(), 2);
    }

    @Test
    public void testGetColor(){
        assertEquals("Color should be red", saab.getColor(), Color.red);
    }

    @Test
    public void testGetEnginePower(){
        assertTrue("Engine power should be 125", saab.getEnginePower() == 125);
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
        saab.setDirection("South");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "West");
    }

    @Test
    public void testTurnRightFromWest(){
        saab.setDirection("West");
        saab.turnRight();
        String newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, "North");
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
    public void testMoveNorth(){
        saab.setDirection("North");
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Wrong position", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveEast(){
        saab.setDirection("East");
        double oldPosition = saab.getXPosition();

        saab.move();
        double newPosition = saab.getXPosition();
        assertTrue("Wrong position", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveSouth(){
        saab.setDirection("South");
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Wrong position", oldPosition - saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveWest(){
        saab.setDirection("West");
        double oldPosition = saab.getXPosition();

        saab.move();
        double newPosition = saab.getXPosition();
        assertTrue("Wrong position", oldPosition - saab.getCurrentSpeed() == newPosition);
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
