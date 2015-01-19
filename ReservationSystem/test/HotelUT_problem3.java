
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import reservationsystem.Hotel;
import reservationsystem.QueryResult;
import reservationsystem.Room;

public class HotelUT_problem3 {
    
    public HotelUT_problem3() {
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
    public void Test_3_1() 
    {
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("F", 2);
        
        room1.setOutOfSeasonPrice(200);
        
        hotel.add(room1);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 4, 1);
        
        hotel.addSesonPrice(start, end, 10,room1.name());
        hotel.addSesonPrice(end, new GregorianCalendar(2014, 4, 15), 100, room1.name());
        
        List<QueryResult> result = hotel.findFreeRooms(new GregorianCalendar(2014, 1, 1), 
                                                       new GregorianCalendar(2014, 1, 3),
                                                       2);
        
        assertEquals(1, result.size());
        assertEquals(20, result.get(0).price(), 1.0e-4);
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 3, 30), 
                                     new GregorianCalendar(2014, 4, 2),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals(110, result.get(0).price(), 1.0e-4);
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 0, 31), 
                                     new GregorianCalendar(2014, 1, 2),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals(210, result.get(0).price(), 1.0e-4);
        
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 0, 2), 
                                     new GregorianCalendar(2014, 0, 4),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals(400, result.get(0).price(), 1.0e-4);
        
        System.out.println("Test_3_1 PASS");
    }
}
