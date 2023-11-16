import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import java.awt.*;

public class CarTest {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95(0,0);
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
    public void testSetColor(){
        saab.setColor(Color.black);
        assertEquals("Color should be black", saab.getColor(), Color.black);
    }

    @Test
    public void testStartEngine(){
        saab.stopEngine();
        saab.startEngine();
        assertTrue("Current speed should be 0.1", saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGetEnginePower(){
        assertTrue("Engine power should be 125", saab.getEnginePower() == 125);
    }

    @Test
    public void testTurnLeftFromSouth(){
        saab.setDirection(Directions.SOUTH);
        saab.turnLeft();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be West", newDirection, Directions.EAST);
    }

    @Test
    public void testTurnLeftFromWest(){
        saab.setDirection(Directions.WEST);
        saab.turnLeft();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, Directions.SOUTH);
    }
    @Test
    public void testTurnLeftFromEast(){
        saab.setDirection(Directions.EAST);
        saab.turnLeft();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be North", newDirection, Directions.NORTH);
    }

    @Test
    public void testTurnLeftFromNorth(){
        saab.setDirection(Directions.NORTH);
        saab.turnLeft();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be West", newDirection, Directions.WEST);
    }
    @Test
    public void testTurnRightFromSouth(){
        saab.setDirection(Directions.SOUTH);
        saab.turnRight();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be west", newDirection, Directions.WEST);
    }

    @Test
    public void testTurnRightFromWest(){
        saab.setDirection(Directions.WEST);
        saab.turnRight();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be North", newDirection, Directions.NORTH);
    }
    @Test
    public void testTurnRightFromEast(){
        saab.setDirection(Directions.EAST);
        saab.turnRight();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, Directions.SOUTH);
    }

    @Test
    public void testTurnRightFromNorth(){
        saab.setDirection(Directions.NORTH);
        saab.turnRight();
        Directions newDirection = saab.getDirection();
        assertEquals("New direction should be East", newDirection, Directions.EAST);
    }

    @Test
    public void testMoveNorth(){
        saab.setDirection(Directions.NORTH);
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Y position should increase", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveEast(){
        saab.setDirection(Directions.EAST);
        double oldPosition = saab.getXPosition();

        saab.move();
        double newPosition = saab.getXPosition();
        assertTrue("X position should increase", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveSouth(){
        saab.setDirection(Directions.SOUTH);
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Y position should decrease", oldPosition - saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveWest(){
        saab.setDirection(Directions.WEST);
        double oldPosition = saab.getXPosition();

        saab.move();
        double newPosition = saab.getXPosition();
        assertTrue("X Position should decrease", oldPosition - saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testGas(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        double currentSpeed = saab.getCurrentSpeed();
        assertTrue("test gas", oldSpeed < currentSpeed);
    }

    @Test
    public void testBrake(){
        saab.stopEngine();
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(0.5);
        double currentSpeed = saab.getCurrentSpeed();
        assertTrue("test break", oldSpeed > currentSpeed);
    }

    @Test
    public void testIsStationary(){
        saab.gas(0.5);
        assertFalse("Should not be stationary", saab.isStationary());
    }

}
