import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ScaniaTest {
    private Scania scania;

    @Before
    public void setup() {scania = new Scania(0,0);}

    @Test
    public void testPlatformMax(){
        scania.tiltPlatform(80);
        assertEquals("Platform Angle should max out at 70 degrees", 70, scania.getPlatformAngle(), 0.0);
    }
    @Test
    public void testPlatformMin(){
        scania.tiltPlatform(-5);
        assertEquals("Platform should go to 0 degrees", 0, scania.getPlatformAngle(), 0.0);
    }

    @Test
    public void testSpeedFactor(){
        assertEquals("Speedfactor should be 1", 1, scania.speedFactor(), 0.0);
    }

    @Test
    public void testBrake(){
        scania.gas(0.5);
        double InitialSpeed = scania.getCurrentSpeed();
        scania.brake(0.5);
        assertTrue("Speed should decrease",InitialSpeed > scania.getCurrentSpeed());

    }

    @Test
    public void testPlatformIsUp(){
        scania.setPlatformAngle(0);
        assertTrue("PlatformIsUp should return True", scania.platformIsUp());

    }

    @Test
    public void testTiltPlatform(){
        scania.tiltPlatform(20);
        assertTrue("degrees should be 20", 20 == scania.getPlatformAngle());
    }


}
