import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemiTruckTest {
    private SemiTruck semi;
    private Volvo240 newCar;

    @Before
    public void setup() {
        semi = new SemiTruck(0,0);
        newCar = new Volvo240(0, 0);
    }

    @Test
    public void testSetPlatformDown(){
        semi.setPlatformAngle(0);
        semi.setPlatformDown();
        assertEquals("platform should be down", 70, semi.getPlatformAngle(),0);
    }

    @Test
    public void testSetPlatformUp(){
        semi.setPlatformDown();
        semi.setPlatformUp();
        assertTrue("platform should be up", semi.platformIsUp());
    }

    @Test
    public void testSpeedfactor(){
        assertEquals("should return 1", 1, semi.speedFactor(),0);
    }

    @Test
    public void testGetMaxSize(){
        assertEquals("should return 5", 5, semi.getMaxSize(),0);
    }
    @Test
    public void testGetCapacity(){
        assertEquals("should return 4", 4, semi.getCapacity(),0);
    }
    @Test
    public void testNotLoaded(){
        assertFalse("should be false", semi.isLoaded());
    }
    @Test
    public void testIsLoaded(){
        semi.setPlatformDown();
        semi.load(newCar);
        assertTrue("should be true", semi.isLoaded());
        semi.unload(newCar);
        assertFalse("should be false", semi.isLoaded());
    }

    @Test
    public void testTurnLeftFromSouth(){
        semi.setDirection(Directions.SOUTH);
        semi.turnLeft();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be West", newDirection, Directions.EAST);
    }

    @Test
    public void testTurnLeftFromWest(){
        semi.setDirection(Directions.WEST);
        semi.turnLeft();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be South", newDirection, Directions.SOUTH);
    }
    @Test
    public void testTurnLeftFromEast(){
        semi.setDirection(Directions.EAST);
        semi.turnLeft();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be North", newDirection, Directions.NORTH);
    }

    @Test
    public void testTurnLeftFromNorth(){
        semi.setDirection(Directions.NORTH);
        semi.turnLeft();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be West", newDirection, Directions.WEST);
    }
    @Test
    public void testTurnRightFromSouth(){
        semi.setDirection(Directions.SOUTH);
        semi.turnRight();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be west", newDirection, Directions.WEST);
    }

    @Test
    public void testTurnRightFromWest(){
        semi.setDirection(Directions.WEST);
        semi.turnRight();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be North", newDirection, Directions.NORTH);
    }
    @Test
    public void testTurnRightFromEast(){
        semi.setDirection(Directions.EAST);
        semi.turnRight();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be South", newDirection, Directions.SOUTH);
    }

    @Test
    public void testTurnRightFromNorth(){
        semi.setDirection(Directions.NORTH);
        semi.turnRight();
        Directions newDirection = semi.getDirection();
        assertEquals("New direction should be East", newDirection, Directions.EAST);
    }

    @Test
    public void testMoveNorth(){
        semi.setDirection(Directions.NORTH);
        double oldPosition = semi.getYPosition();

        semi.move();
        double newPosition = semi.getYPosition();
        assertEquals("Y position should increase", oldPosition + semi.getCurrentSpeed(), newPosition, 0.0);
    }

    @Test
    public void testMoveEast(){
        semi.setDirection(Directions.EAST);
        double oldPosition = semi.getXPosition();

        semi.move();
        double newPosition = semi.getXPosition();
        assertEquals("X position should increase", oldPosition + semi.getCurrentSpeed(), newPosition, 0.0);
    }

    @Test
    public void testMoveSouth(){
        semi.setDirection(Directions.SOUTH);
        double oldPosition = semi.getYPosition();

        semi.move();
        double newPosition = semi.getYPosition();
        assertEquals("Y position should decrease", oldPosition - semi.getCurrentSpeed(), newPosition, 0.0);
    }

    @Test
    public void testMoveWest(){
        semi.setDirection(Directions.WEST);
        double oldPosition = semi.getXPosition();

        semi.move();
        double newPosition = semi.getXPosition();
        assertEquals("X Position should decrease", oldPosition - semi.getCurrentSpeed(), newPosition, 0.0);
    }

    @Test
    public void testAlignContents(){
        semi.setPlatformDown();
        semi.load(newCar);
        semi.setPlatformUp();
        semi.gas(1);
        semi.move();
        semi.turnLeft();
        assertEquals("newCar's X should be equal to X of semi", newCar.getXPosition(), semi.getXPosition(), 0.0);
        assertEquals("newCar's Y should be equal to Y of semi", newCar.getYPosition(), semi.getYPosition(), 0.0);
        assertEquals("newCar's direction should be equal to direction of semi", newCar.getDirection(), semi.getDirection());
    }


}
