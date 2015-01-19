
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import reservationsystem.*;

public class HotelUT_problem4 {
    
    
        
    Hotel hotel = new Hotel();
    
    public HotelUT_problem4() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        
        Room room_1 = new Room("1",1);
        hotel.add(room_1);
        
        Room room_2 = new Room("2", 1);
        hotel.add(room_2);
        
        Room room_3 = new Room("3", 2);
        hotel.add(room_3);
        
        Room room_4 = new Room("4", 2);
        hotel.add(room_4);
        
        Room room_Honeymoon = new Room("Honeymoon", 2);
        hotel.add(room_Honeymoon);
        
        Room room_6 = new Room("6", 3);
        hotel.add(room_6);
        
        Room room_7 = new Room("7", 4);
        hotel.add(room_7);
        
        Room room_Apartament = new Room("Apartament", 4);
        hotel.add(room_Apartament);
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            100,
                            "1");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            90,
                            "1");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            100,
                            "1");
        hotel.setOutOfSeasonPrice(80, "1");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            100,
                            "2");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            90,
                            "2");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            100,
                            "2");
        hotel.setOutOfSeasonPrice(80, "2");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            220,
                            "3");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            200,
                            "3");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            220,
                            "3");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            200,
                            "3");
        hotel.setOutOfSeasonPrice(140, "3");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            220,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            200,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            220,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            200,
                            "4");
        hotel.setOutOfSeasonPrice(140, "4");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 20), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 21),
                            300,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 27), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            300,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 3), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 4),
                            260,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 10), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 11),
                            260,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 27),
                            220,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            200,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            220,
                            "Honeymoon");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            200,
                            "Honeymoon");
        hotel.setOutOfSeasonPrice(160, "Honeymoon");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            320,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            300,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            320,
                            "4");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            300,
                            "4");
        hotel.setOutOfSeasonPrice(200, "4");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            360,
                            "7");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            340,
                            "7");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            360,
                            "7");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            350,
                            "7");
        hotel.setOutOfSeasonPrice(240, "7");
        
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 24), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 28),
                            450,
                            "Apartament");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 28), 
                            new GregorianCalendar(2014, Calendar.DECEMBER, 31),
                            430,
                            "Apartament");
        hotel.addSesonPrice(new GregorianCalendar(2014, Calendar.DECEMBER, 31), 
                            new GregorianCalendar(2015, Calendar.JANUARY, 6),
                            450,
                            "Apartament");
        hotel.addSesonPrice(new GregorianCalendar(2015, Calendar.JANUARY, 17), 
                            new GregorianCalendar(2015, Calendar.FEBRUARY, 1),
                            450,
                            "Apartament");
        hotel.setOutOfSeasonPrice(300, "Apartament");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testRoom2() 
    {

        Room room = hotel.room("2");

        assertNotNull(room);
        assertEquals(80,
                room.price(
                        new GregorianCalendar(2015, Calendar.JANUARY, 15)
                )
        );
        assertEquals(100,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 26)
                )
        );
        assertEquals(90,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 28)
                )
        );

    }
    
    @Test
    public void testRoom5() {



        Room room = hotel.room("Honeymoon");


        assertEquals(220,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 26)
                )
        );

        assertEquals(300,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 27)
                )
        );

        assertEquals(200,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 28)
                )
        );

        assertEquals(160,
                room.price(
                        new GregorianCalendar(2015, Calendar.JANUARY, 7)
                )
        );

    }
}
