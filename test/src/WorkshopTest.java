import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class WorkshopTest {
    private Workshop<Saab95> workshop;
    private Saab95 saab95;

    @Before
    public void setUp(){
        workshop = new Workshop<Saab95>(0,0,10,15);
        saab95 = new Saab95(0,0);
    }

    @Test
    public void testLoad(){
        workshop.load(saab95);
        assertFalse("saab95 should be inactive", saab95.isActive());
    }

    @Test
    public void testUnload(){
        workshop.load(saab95);
        assertFalse("Semi should be inactive", saab95.isActive());
        workshop.unload(saab95);
        assertTrue("Semi should be active", saab95.isActive());
    }
}
