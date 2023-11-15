import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class Saab95WorkshopTest {
    Saab95Workshop workshop;
    private Saab95 s1;
    @Before
    public void setUp(){
        workshop = new Saab95Workshop(0, 0, 2);
        s1 = new Saab95(1, 1);
    }

    @Test
    public void loadTest(){
        workshop.load(s1);
        Assert.assertFalse("s1 should be inactive", s1.isActive());
    }

    @Test
    public void unloadTest(){
        workshop.load(s1);
        Assert.assertFalse("s1 should be inactive", s1.isActive());
        workshop.unload(s1);
        Assert.assertTrue("s1 should be active again", s1.isActive());
    }
}
