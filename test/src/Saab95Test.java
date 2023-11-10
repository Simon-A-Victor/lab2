import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class Saab95Test {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95(0,0);
    }

    @Test
    public void testIncrementSpeed(){
        double originalSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        assertTrue("Speed should increase", originalSpeed < saab.getCurrentSpeed());
    }

    @Test
    public void testGas(){
        saab.stopEngine();
        saab.gas(0.5);
        double originalSpeed = saab.getCurrentSpeed();
        saab.brake(0.5);
        assertTrue("Speed should decrease", originalSpeed > saab.getCurrentSpeed());
    }

    @Test
    public void testTurbo(){
        saab.stopEngine();
        saab.setTurboOff();
        saab.gas(0.5);
        double noTurboSpeed = saab.getCurrentSpeed();

        saab.stopEngine();
        saab.setTurboOn();
        saab.gas(0.5);
        double turboSpeed = saab.getCurrentSpeed();

        assertTrue("Turbo speed should be higher than no turbo", turboSpeed > noTurboSpeed);
    }





}
