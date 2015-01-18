
package constructive.solid.geometry;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class ConstructiveSolidGeometryUnitTest {
    
    public ConstructiveSolidGeometryUnitTest() {}
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}
    
    @Test
    public void testEllipseContains() 
    {
        Ellipse instance = new Ellipse(2.5f, 5.5f);
        
        assertEquals(true, instance.contains(0, 0));
        assertEquals(false, instance.contains(2.5f, 5.5f));
        assertEquals(true, instance.contains(-1.25f, -2.75f));
        assertEquals(true, instance.contains(-1.0f, 2.0f));
        assertEquals(false, instance.contains(-3.0f, 0));
    }
    
    @Test
    public void testIntersectionContains() 
    {
        Rectangle rec1 = new Rectangle(2.0F, 5.0F);
        Rectangle rec2 = new Rectangle(5.0F, 1.0F);
        Intersection instance = new Intersection(rec1, rec2);
        
        assertEquals(true, instance.contains(0.0F, 0.0F));
        assertEquals(true, instance.contains(1.0F, 0.0F));
        assertEquals(false, instance.contains(2.0F, 2.0F));
    }
    
     @Test
    public void testDifferenceContains() 
    {
        Rectangle rec1 = new Rectangle(4.0F, 4.0F);
        Rectangle rec2 = new Rectangle(10.0F, 10.0F);
        Difference instance = new Difference(rec2, rec1);
        
        assertEquals(false, instance.contains(0.0F, 0.0F));
        assertEquals(false, instance.contains(2.0F, 2.0F));
        assertEquals(true, instance.contains(2.1F, 2.1F));
    }
    
    @Test
    public void testRectangleContains() 
    {
        Rectangle instance = new Rectangle(2.5f, 5.5f);
        assertEquals(true, instance.contains(0, 0));
        assertEquals(true, instance.contains(1.25f, 2.75f));
        assertEquals(true, instance.contains(-1.25f, -2.75f));
        assertEquals(true, instance.contains(-1.0f, 2.0f));
        assertEquals(false, instance.contains(-3.0f, 0));
        assertEquals(true, (new Rectangle(6, 12)).contains(-0.05539f, -2.936f));
    }
    
    @Test
    public void testRotatedContains()
    {
        Rectangle rec = new Rectangle(5.0F, 5.0F);
        Rotated instance = new Rotated(0F, 0F, 45.0F, rec);
        assertEquals(true, instance.contains(0.0F, 2.6F));
    }
    
    @Test
    public void testTranslatedContains() 
    {
        Rectangle rec = new Rectangle(2.0F, 2.0F);
        Translated instance = new Translated(5.0F, 5.0F, rec);
        
        assertEquals(false, instance.contains(0.0F, 0.0F));
        assertEquals(true, instance.contains(5.0F, 5.0F));
    }
    
    @Test
    public void testUnionContains() 
    {
        Rectangle rec1 = new Rectangle(1.0F, 5.0F);
        Rectangle rec2 = new Rectangle(5.0F, 1.0F);
        Union instance = new Union(rec1, rec2);
        
        assertEquals(true, instance.contains(2.0F, 0.0F));
        assertEquals(false, instance.contains(2.0F, 2.0F));
        
    }
}
