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
        Room resRoom = searchResult.get(0);
        
        assertEquals(expResultListSize, result.size());
        System.out.println("testFindFreeRoomsOneRoom - liczba mozliwosc " + result.size());
        assertEquals(expResultListSize, searchResult.size());
        System.out.println("testFindFreeRoomsOneRoom - liczba pokojow jedynej możliwości " + searchResult.size());
        assertEquals(roomName, resRoom.name());
        System.out.println("testFindFreeRoomsOneRoom - nazwa tego pokoju " + resRoom.name());
        assertEquals(numberOfPersons, resRoom.n_persons());
        System.out.println("testFindFreeRoomsOneRoom - pojemnosc pokoju " + resRoom.n_persons());
        assertEquals(price*7, firstRecord.price());
        System.out.println("testFindFreeRoomsOneRoom - cena " + firstRecord.price());
        assertSame("Bledny pokoj", room, resRoom);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel.
     * scenario: Hotel with one single room, two 2 persons rooms and one 4 persons room
     */
    @Test
    public void testFindFreeRoomsFewRooms() {
        System.out.println("testFindFreeRoomsFewRooms");
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        int n_persons = 3;
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("jedynka", 1, 120);
        Room room2_1 = new Room("dwójka-1", 2, 180);
        Room room2_2 = new Room("dwójka-2", 2, 180);
        Room room4 = new Room("czwórka", 4, 300);
        
        hotel.add(room1);
        hotel.add(room2_1);
        hotel.add(room2_2);
        hotel.add(room4);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, n_persons);
        int expResultListSize = 0;
        
        assertEquals(expResultListSize, result.size());
        System.out.println("testFindFreeRoomsFewRooms - liczba mozliwosci " + result.size());
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
