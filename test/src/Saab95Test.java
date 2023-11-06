import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class Saab95Test {
    private Saab95 saab;

    @Before
    public void setUp(){
        saab = new Saab95();
    }

    @Test
    public void testDoors(){
        assertEquals("Number of doors", saab.getNrDoors(), 2);
    }




}
