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



}
