
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import reservationsystem.Room;


public class RoomTest {
    
    public RoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void Test_1_1() {
        System.out.println("\nTest_1_1 START");
        
        Room room1 = new Room("A", 2);
        
        assertEquals(2, room1.n_persons());
        assertEquals("A", room1.name());
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        assertEquals(true, room1.isFree(start, end));
        
        room1.reserve(start, end, null);
        
        assertEquals(false, room1.isFree(start, end));

        assertEquals(true, room1.isFree(new GregorianCalendar(2014, 1, 9), 
                                        new GregorianCalendar(2014, 1, 10)));
        
        assertEquals(true, room1.isFree(new GregorianCalendar(2014, 1, 8),
                                        new GregorianCalendar(2014, 1, 10)));
        
        assertEquals(false, room1.isFree(new GregorianCalendar(2014, 1, 7), 
                                        new GregorianCalendar(2014, 1, 10)));
        
        assertEquals(false, room1.isFree(new GregorianCalendar(2014, 1, 1), 
                                        new GregorianCalendar(2014, 1, 7)));
        
        assertEquals(false, room1.isFree(new GregorianCalendar(2013, 12, 29), 
                                        new GregorianCalendar(2014, 1, 7)));
        
        assertEquals(false, room1.isFree(new GregorianCalendar(2014, 1, 2), 
                                        new GregorianCalendar(2014, 1, 5)));
        
        assertEquals(true, room1.isFree(new GregorianCalendar(2014, 1, 8), 
                                        new GregorianCalendar(2014, 1, 10)));
        
        assertEquals(true, room1.isFree(new GregorianCalendar(2014, 1, 9), 
                                        new GregorianCalendar(2014, 1, 10)));
        
        System.out.println("Test_1_1 PASS");
    }
    
}
