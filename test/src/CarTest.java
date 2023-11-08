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
