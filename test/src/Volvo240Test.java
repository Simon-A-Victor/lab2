import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class Volvo240Test {
    private Volvo240 volvo;

    @Before
    public void setUp(){
        volvo = new Volvo240(0,0);
    }

    @Test
    public void testIncrementSpeed(){
        double originalSpeed = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        assertTrue("Speed should increase", originalSpeed < volvo.getCurrentSpeed());

    }
    @Test
    public void testDecrementSpeed(){
        volvo.gas(1);
        double originalSpeed = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue("Speed should decrease", originalSpeed > volvo.getCurrentSpeed());
    }


}


