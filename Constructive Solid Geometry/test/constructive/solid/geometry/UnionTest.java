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
public class UnionTest {
    
    public UnionTest() {
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
     * Test of contains method, of class Union.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        Rectangle rec1 = new Rectangle(1.0F, 5.0F);
        Rectangle rec2 = new Rectangle(5.0F, 1.0F);
        Union instance = new Union(rec1, rec2);
        
        assertEquals(true, instance.contains(2.0F, 0.0F));
        assertEquals(false, instance.contains(2.0F, 2.0F));
        
    }
    
}
