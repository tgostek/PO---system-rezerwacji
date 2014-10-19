/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     */
    @Test
    public void testFindFreeRoomsEmptyHotel() {
        System.out.println("findFreeRoomsEmptyHotel");
        Calendar start = null;
        Calendar end = null;
        int n_persons = 0;
        Hotel instance = new Hotel();
        List<QueryResult> expResult = null;
        List<QueryResult> result = instance.findFreeRooms(start, end, n_persons);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
