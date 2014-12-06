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
public class RotatedTest {
    
    public RotatedTest() {
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
     * Test of contains method, of class Rotated.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        Rectangle rec = new Rectangle(5.0F, 5.0F);
        Rotated instance = new Rotated(0F, 0F, 45.0F, rec);
        assertEquals(true, instance.contains(0.0F, 2.6F));
    }
    
}
