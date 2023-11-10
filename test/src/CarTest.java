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
        saab.setDirection(Car.Directions.SOUTH);
        saab.turnLeft();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be West", newDirection, Car.Directions.EAST);
    }

    @Test
    public void testTurnLeftFromWest(){
        saab.setDirection(Car.Directions.WEST);
        saab.turnLeft();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, Car.Directions.SOUTH);
    }
    @Test
    public void testTurnLeftFromEast(){
        saab.setDirection(Car.Directions.EAST);
        saab.turnLeft();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be North", newDirection, Car.Directions.NORTH);
    }

    @Test
    public void testTurnLeftFromNorth(){
        saab.setDirection(Car.Directions.NORTH);
        saab.turnLeft();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be West", newDirection, Car.Directions.WEST);
    }
    @Test
    public void testTurnRightFromSouth(){
        saab.setDirection(Car.Directions.SOUTH);
        saab.turnRight();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be west", newDirection, Car.Directions.WEST);
    }

    @Test
    public void testTurnRightFromWest(){
        saab.setDirection(Car.Directions.WEST);
        saab.turnRight();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be North", newDirection, Car.Directions.NORTH);
    }
    @Test
    public void testTurnRightFromEast(){
        saab.setDirection(Car.Directions.EAST);
        saab.turnRight();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be South", newDirection, Car.Directions.SOUTH);
    }

    @Test
    public void testTurnRightFromNorth(){
        saab.setDirection(Car.Directions.NORTH);
        saab.turnRight();
        Car.Directions newDirection = saab.getDirection();
        assertEquals("New direction should be East", newDirection, Car.Directions.EAST);
    }

    @Test
    public void testMoveNorth(){
        saab.setDirection(Car.Directions.NORTH);
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Y position should increase", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveEast(){
        saab.setDirection(Car.Directions.EAST);
        double oldPosition = saab.getXPosition();

        saab.move();
        double newPosition = saab.getXPosition();
        assertTrue("X position should increase", oldPosition + saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveSouth(){
        saab.setDirection(Car.Directions.SOUTH);
        double oldPosition = saab.getYPosition();

        saab.move();
        double newPosition = saab.getYPosition();
        assertTrue("Y position should decrease", oldPosition - saab.getCurrentSpeed() == newPosition);
    }

    @Test
    public void testMoveWest(){
        saab.setDirection(Car.Directions.WEST);
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
