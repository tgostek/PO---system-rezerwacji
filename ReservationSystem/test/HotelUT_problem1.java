
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import reservationsystem.*;

public class HotelUT_problem1 {
    
    public HotelUT_problem1() {
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
    public void Test_1_1() 
    {
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("1", 4);
        hotel.add(room1);
        
        Room room2 = hotel.room("1");
        
        assertEquals(room1, room2);
        assertEquals(4, room2.n_persons());
        
        System.out.println("Test_1_1 PASS");
    }
    
    @Test
    public void Test_1_2() 
    {
        Hotel hotel = new Hotel();
        
        assertEquals(0, hotel.findFreeRooms(null, null, 9).size());
        
        System.out.println("Test_1_2 PASS");
    }
    
    @Test
    public void Test_1_3() 
    {
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("1", 2);
        
        room1.setOutOfSeasonPrice(180);
        
        hotel.add(room1);
        
        assertEquals("1", hotel.room("1").name());
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        List<QueryResult> qr = hotel.findFreeRooms(start, end, 2);
        assertEquals(1, qr.size());
        
        QueryResult qr_item = qr.get(0);
        assertEquals(1, qr_item.rooms().size());
        
        Room room = qr_item.rooms().get(0);
        assertEquals(2, room.n_persons());
        assertEquals("1", room.name());
        
        assertEquals(1260, qr_item.price(), 1.0e-4);
        
        System.out.println("Test_1_3 PASS");
    }
    
    @Test
    public void Test_1_4() 
    {
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("1", 2);
        Room room2 = new Room("2", 2);
        Room room3 = new Room("3", 3);
        Room room4 = new Room("4", 1);
        Room room5 = new Room("5", 1);
        Room room6 = new Room("6", 1);
        
        room1.setOutOfSeasonPrice(180);
        room2.setOutOfSeasonPrice(180);
        room3.setOutOfSeasonPrice(180);
        room4.setOutOfSeasonPrice(90);
        room5.setOutOfSeasonPrice(90);
        room6.setOutOfSeasonPrice(90);
        
        hotel.add(room1);
        hotel.add(room2);
        hotel.add(room3);
        hotel.add(room4);
        hotel.add(room5);
        hotel.add(room6);
        
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> qr = hotel.findFreeRooms(start, end, 2);
        assertEquals(6, qr.size());
        
        System.out.println("Test_1_4 PASS");
    }
}
