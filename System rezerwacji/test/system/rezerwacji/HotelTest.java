/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

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
        Room room11 = new Room("CI", 5, 1000);
        
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
        hotel.add(room11);
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 2);
        
        List<QueryResult> result = hotel.findFreeRooms(start, end, 3);
        
        assertEquals(6, result.size());
        assertEquals(250, result.get(0).price());
        assertTrue(3  <= result.get(0).n_person());
        
        
        // test method void reserve(Calendar start, Calendar end, QueryResult result, Person person);
        Person person = new Person();
        person.setFirstName("FirstName");
        person.setName("Name");
        person.setAddress("Address");
        person.setEmail("mail@com.pl");
        
        hotel.reserve(start, end, result.get(0), person);
        List<Room> tmpRooms = result.get(0).rooms();
        for (Room room: tmpRooms) {
            assertEquals(false, room.isFree(start, end));
        }
        assertEquals(true, room11.isFree(start, end));
        System.out.println("Test_2_2 PASS");
    }
    
    @Test
    public void Test_2_3() {
        System.out.println("\nTest_2_3 START");
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("A", 1, 100);
        Room room2 = new Room("B", 1, 100);
        Room room3 = new Room("C", 1, 100);
        Room room4 = new Room("D", 1, 100);
        
        
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
        
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(0, result.size());
        
        Room room5 = new Room("E", 4, 100);
        hotel.add(room5);
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(4, result.size());
        
        
        Room room6 = new Room("F", 6, 200);
        hotel.add(room6);
        result = hotel.findFreeRooms(start, end, 5);
        assertEquals(5, result.size());
        
        System.out.println("Test_2_3 PASS");
    }
    
    @Test
    public void Test_3_1() {
        System.out.println("\nTest_3_1 START");
        
        TableOfSesonProcentPrice tableOfSesonProcentPrice = new TableOfSesonProcentPrice();
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 4, 1);
        
        tableOfSesonProcentPrice.addIRecord(start, end, 10);
        tableOfSesonProcentPrice.addIRecord(end, new GregorianCalendar(2014, 4, 15), 100);
        
        Hotel hotel = new Hotel();
        
        Room room1 = new Room("F", 2, 200);
        
        room1.setTableOfSesonProcentPrice(tableOfSesonProcentPrice);
        hotel.add(room1);
        
        List<QueryResult> result = hotel.findFreeRooms(new GregorianCalendar(2014, 1, 1), 
                                                       new GregorianCalendar(2014, 1, 3),
                                                       2);
        assertEquals(1, result.size());
        assertEquals((440), result.get(0).price());
        
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 3, 30), 
                                     new GregorianCalendar(2014, 4, 2),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals((620), result.get(0).price());
        
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 0, 31), 
                                     new GregorianCalendar(2014, 1, 2),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals((420), result.get(0).price());
        
        result = hotel.findFreeRooms(new GregorianCalendar(2014, 0, 2), 
                                     new GregorianCalendar(2014, 0, 4),
                                     2);
        
        assertEquals(1, result.size());
        assertEquals((400), result.get(0).price());
        
        System.out.println("Test_3_1 PASS");
    }
}
