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
public class TranslatedTest {
    
    public TranslatedTest() {
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
     * Test of contains method, of class Translated.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        
        Rectangle rec = new Rectangle(2.0F, 2.0F);
        Translated instance = new Translated(5.0F, 5.0F, rec);
        
        assertEquals(false, instance.contains(0.0F, 0.0F));
        assertEquals(true, instance.contains(5.0F, 5.0F));
        
    }
    
}
