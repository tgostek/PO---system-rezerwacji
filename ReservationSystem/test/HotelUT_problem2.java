
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import reservationsystem.Hotel;
import reservationsystem.Person;
import reservationsystem.QueryResult;
import reservationsystem.Room;

public class HotelUT_problem2 {
    
    public HotelUT_problem2() {
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
    public void Test_2_1() 
    {
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("1", 2);
        Room room2 = new Room("2", 2);
        Room room3 = new Room("3", 4);
        Room room4 = new Room("4", 1);
        
        room1.setOutOfSeasonPrice(180);
        room2.setOutOfSeasonPrice(180);
        room3.setOutOfSeasonPrice(300);
        room4.setOutOfSeasonPrice(120);
        
        hotel.add(room1);
        hotel.add(room2);
        hotel.add(room3);
        hotel.add(room4);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> qr = hotel.findFreeRooms(start, end, 3);
        assertEquals(3, qr.size());
        
        System.out.println("Test_2_1 PASS");
    }
    
       @Test
    public void Test_2_2() {
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("1", 2);
        Room room2 = new Room("2", 2);
        Room room3 = new Room("3", 4);
        Room room4 = new Room("4", 1);
        Room room5 = new Room("5", 5);
        
        room1.setOutOfSeasonPrice(180);
        room2.setOutOfSeasonPrice(180);
        room3.setOutOfSeasonPrice(300);
        room4.setOutOfSeasonPrice(120);
        room5.setOutOfSeasonPrice(500);
        
        hotel.add(room1);
        hotel.add(room2);
        hotel.add(room3);
        hotel.add(room4);
        hotel.add(room5);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 3);
        
        assertEquals(3, result.size());
        
        Person person = new Person("","","","");
        
        hotel.reserve(start, end, result.get(0), person);
        List<Room> tmpRooms = result.get(0).rooms();
        for (Room room: tmpRooms) {
            assertEquals(false, room.isFree(start, end));
        }
        assertEquals(true, room5.isFree(start, end));
        System.out.println("Test_2_2 PASS");
    }
    
    @Test
    public void Test_2_3() {
        
        Hotel hotel = new Hotel();
        
        
       Room room1 = new Room("1", 1);
       Room room2 = new Room("2", 1);
       Room room3 = new Room("3", 1);
       Room room4 = new Room("4", 1);
       
       room1.setOutOfSeasonPrice(100);
       room2.setOutOfSeasonPrice(100);
       room3.setOutOfSeasonPrice(100);
       room4.setOutOfSeasonPrice(100);
       
       hotel.add(room1);
       hotel.add(room2);
       hotel.add(room3);
       hotel.add(room4);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 3);

        assertEquals(3, result.size());
        assertEquals(300, result.get(0).price(), 1.0e-4);
        assertTrue(3  <= result.get(0).n_person());
        
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(0, result.size());
        
        Room room5 = new Room("E", 4);
        room5.setOutOfSeasonPrice(100);
        hotel.add(room5);
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(4, result.size());
        
        
        Room room6 = new Room("F", 6);
        room5.setOutOfSeasonPrice(200);
        hotel.add(room6);
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(1, result.size());
        
        System.out.println("Test_2_3 PASS");
    }
}
