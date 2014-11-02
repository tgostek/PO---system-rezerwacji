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
     * Find rooms in a hotel without any rooms. Should return an empty list.
     */
    @Test
    public void Test_1_1() {
        System.out.println("\nTest_1_1 START");
        
        Hotel hotel = new Hotel();
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 2);
        
        assertEquals(0, result.size());
        
        System.out.println("Test_1_1 PASS");
    }
    
    
    /**
     * Find a room for two persons in an empty hotel containing only one double room. 
     * Should return a list with exactly one QueryResult. 
     * Calling rooms() on this result should return the one element list with one room. 
     * Method price() should return 180*(number of nights).
     */
    @Test
    public void Test_1_2() {
        System.out.println("\nTest_1_2 START");
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("A", 2, 180);
        
        hotel.add(room1);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 2);
        
        assertEquals(1, result.size());
        assertEquals(180*7, result.get(0).price());
        
        System.out.println("Test_1_2 PASS");
    }
    
    /**
     * The hotel has one single room, two 2 persons rooms and one 4 persons room. 
     * Find accommodation for three persons. Single room cost 120 per night, double
     * room cost 180 per night and four person room costs 300 per night. 
     * Should return a list of the three cheapest possibilities (single room + double room, 4 persons room).
    */
    @Test
    public void Test_2_1() {
        System.out.println("\nTest_2_1 START");
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("A", 1, 120);
        Room room2 = new Room("B", 2, 180);
        Room room3 = new Room("C", 2, 180);
        Room room4 = new Room("D", 4, 300);
        
        
        hotel.add(room1);
        hotel.add(room2);
        hotel.add(room3);
        hotel.add(room4);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 3);

        assertEquals(3, result.size());
        assertEquals(300, result.get(0).price());
        assertTrue(3  <= result.get(0).n_person());
        
        
        System.out.println("Test_2_1 PASS");
    }
    
    @Test
    public void Test_2_2() {
        System.out.println("\nTest_2_2 START");
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("A", 1, 120);
        Room room2 = new Room("B", 2, 180);
        Room room3 = new Room("C", 2, 180);
        Room room4 = new Room("D", 4, 300);
        
        Room room5 = new Room("CC", 3, 300);
        Room room6 = new Room("CD", 1, 100);
        Room room7 = new Room("CE", 2, 150);
        Room room8 = new Room("CF", 2, 150);
        Room room9 = new Room("CG", 1, 100);
        Room room10 = new Room("CH", 1, 100);
        
        hotel.add(room1);
        hotel.add(room2);
        hotel.add(room3);
        hotel.add(room4);
        hotel.add(room5);
        hotel.add(room6);
        hotel.add(room7);
        hotel.add(room8);
        hotel.add(room9);
        hotel.add(room10);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 3);
        
        assertEquals(6, result.size());
        assertEquals(250, result.get(0).price());
        assertTrue(3  <= result.get(0).n_person());
        
        
        
        System.out.println("Test_2_2 PASS");
    }
    
}
