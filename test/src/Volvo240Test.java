import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class Volvo240Test {
    private Volvo240 volvo;

    @Before
    public void setUp(){
        volvo = new Volvo240();
    }

    @Test
    public void testIncrementSpeed(){
        double originalSpeed = volvo.getCurrentSpeed();
        volvo.incrementSpeed(2);
        assertTrue("Speed should increase", originalSpeed < volvo.getCurrentSpeed());

    }
    @Test
    public void testDecrementSpeed(){
        volvo.incrementSpeed(10);
        double originalSpeed = volvo.getCurrentSpeed();
        volvo.decrementSpeed(2);
        assertTrue("Speed should decrease", originalSpeed > volvo.getCurrentSpeed());
    }


}


