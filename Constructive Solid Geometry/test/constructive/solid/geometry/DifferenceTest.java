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
public class DifferenceTest {
    
    public DifferenceTest() {
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
     * Test of contains method, of class Difference.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        Rectangle rec1 = new Rectangle(4.0F, 4.0F);
        Rectangle rec2 = new Rectangle(10.0F, 10.0F);
        Difference instance = new Difference(rec2, rec1);
        
        assertEquals(false, instance.contains(0.0F, 0.0F));
        assertEquals(false, instance.contains(2.0F, 2.0F));
        assertEquals(true, instance.contains(2.1F, 2.1F));
    }
    
}
