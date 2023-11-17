import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class GeneralWorkshopTest {
    private GeneralWorkshop workshop;
    private SemiTruck semi;

    @Before
    public void setUp(){
        workshop = new GeneralWorkshop(0,0,10,15);
        semi = new SemiTruck(0,0);
    }

    @Test
    public void testLoad(){
        workshop.load(semi);
        assertFalse("Semi should be inactive", semi.isActive());
    }

    @Test
    public void testUnload(){
        workshop.load(semi);
        assertFalse("Semi should be inactive", semi.isActive());
        workshop.unload(semi);
        assertTrue("Semi should be active", semi.isActive());
    }
}
