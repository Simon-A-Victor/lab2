import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class Saab95Test {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95();
    }

    @Test
    public void testIncrementSpeed(){
        double originalSpeed = saab.getCurrentSpeed();
        saab.incrementSpeed(2);
        assertTrue("Speed should increase", originalSpeed < saab.getCurrentSpeed());
    }

    @Test
    public void testDecrementSpeed(){
        double originalSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(2);
        assertTrue("Speed should decrease", originalSpeed > saab.getCurrentSpeed());
    }

    @Test
    public void testTurbo(){
        saab.stopEngine();
        saab.setTurboOff();
        saab.incrementSpeed(2);
        double noTurboSpeed = saab.getCurrentSpeed();

        saab.stopEngine();
        saab.setTurboOn();
        saab.incrementSpeed(2);
        double turboSpeed = saab.currentSpeed;

        assertTrue("Turbo speed should be higher than no turbo", turboSpeed > noTurboSpeed);
    }





}
