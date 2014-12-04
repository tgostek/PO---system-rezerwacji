/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

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
public class EllipseTest {
    
    public EllipseTest() {
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
     * Test of contains method, of class Ellipse.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        Ellipse instance = new Ellipse(2.5f, 5.5f);
        
        assertEquals(true, instance.contains(0, 0));
        assertEquals(false, instance.contains(2.5f, 5.5f));
        assertEquals(true, instance.contains(-1.25f, -2.75f));
        assertEquals(true, instance.contains(-1.0f, 2.0f));
        assertEquals(false, instance.contains(-3.0f, 0));
        
    }
    
}
