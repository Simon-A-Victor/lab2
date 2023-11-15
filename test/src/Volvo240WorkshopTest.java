import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Volvo240WorkshopTest {
    Volvo240Workshop workshop;
    private Volvo240 v1;

    @Before
    public void setUp(){
        workshop = new Volvo240Workshop(0, 0, 2);
        v1 = new Volvo240(1, 1);
    }

    @Test
    public void loadTest(){
        workshop.load(v1);
        Assert.assertFalse("v1 should be inactive", v1.isActive());
    }

    @Test
    public void unloadTest(){
        workshop.load(v1);
        Assert.assertFalse("v1 should be inactive", v1.isActive());
        workshop.unload(v1);
        Assert.assertTrue("v1 should be active again", v1.isActive());
    }
}