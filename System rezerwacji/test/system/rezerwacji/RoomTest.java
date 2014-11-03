/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.rezerwacji;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulina
 */
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
    public void Test_1_2() {
        System.out.println("\nTest_1_1 START");
        
        Room room1 = new Room("A", 2, 180);
        
        assertEquals(2, room1.n_persons());
        assertEquals("A", room1.name());
        assertEquals(180, room1.price());
        
        Calendar start = new GregorianCalendar(2014, 1, 1);
        Calendar end = new GregorianCalendar(2014, 1, 8);
        
        room1.reserve(start, end, null);
        
        assertEquals(false, room1.isFree(start, end));
        
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
