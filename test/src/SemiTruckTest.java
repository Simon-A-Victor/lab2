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
    public void testTiltPlatformUpToDown(){
        semi.setPlatformAngle(0);
        semi.tiltPlatform();
        assertEquals("platform should be up", 70, semi.getPlatformAngle(),0);
    }

    @Test
    public void testTiltPlatformDownToUp(){
        semi.setPlatformAngle(70);
        semi.tiltPlatform();
        assertEquals("platform should be down", 0, semi.getPlatformAngle(),0);
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
        semi.tiltPlatform();
        semi.load(newCar);
        assertTrue("should be true", semi.isLoaded());
    }


}
