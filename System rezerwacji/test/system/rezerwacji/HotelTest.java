/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tomaszgostek
 */
public class HotelTest {
    
    public HotelTest() {
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

    /**
     * Test of findFreeRooms method, of class Hotel.
     * scenario: Empty Hotel
     */
    @Test
    public void testFindFreeRoomsEmptyHotel() {
        System.out.println("findFreeRoomsEmptyHotel");
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        int n_persons = 0;
        Hotel hotel = new Hotel();
        List<QueryResult> expResult = new ArrayList<QueryResult>();
        List<QueryResult> result = hotel.findFreeRooms(start, end, n_persons);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel.
     * scenario: Hotel with only one room for 2 persons
     */
    @Test
    public void testFindFreeRoomsOneRoom() {
        System.out.println("testFindFreeRoomsOneRoom");
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        int n_persons = 2;
        Hotel hotel = new Hotel();
        String roomName = "test_name";
        int numberOfPersons = 2;
        int price = 180;
        Room room = new Room(roomName, numberOfPersons, price);
        hotel.add(room);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, n_persons);
        int expResultListSize = 1;
        
        QueryResult firstRecord = result.get(0);
        List<Room> searchResult = firstRecord.rooms();
        Room expRoom = searchResult.get(0);
        
        assertEquals(expResultListSize, result.size());
        System.out.println("testFindFreeRoomsOneRoom - liczba możliwość " + result.size());
        assertEquals(expResultListSize, searchResult.size());
        System.out.println("testFindFreeRoomsOneRoom - liczba pokojów jedynej możliwości " + searchResult.size());
        assertEquals(roomName, expRoom.name());
        System.out.println("testFindFreeRoomsOneRoom - nazwa tego pokoju " + expRoom.name());
        assertEquals(numberOfPersons, expRoom.n_persons());
        System.out.println("testFindFreeRoomsOneRoom - pojemność pokoju " + expRoom.n_persons());
        assertEquals(price*7, firstRecord.price());
        System.out.println("testFindFreeRoomsOneRoom - cena " + firstRecord.price());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetNumberOfNights() {
        System.out.println("testGetNumberOfNights");
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        int expResult = 7;
        int result = Hotel.getCountOfNights(start, end);
        
        assertEquals(expResult, result);
    }
}
