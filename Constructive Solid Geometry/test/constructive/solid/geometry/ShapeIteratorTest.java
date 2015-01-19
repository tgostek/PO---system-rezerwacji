
package constructive.solid.geometry;

import org.junit.*;
import static org.junit.Assert.*;

public class ShapeIteratorTest {
    
    public ShapeIteratorTest() {
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
    public void testVisitor() throws Exception 
    {
        Shape yy = new Rotated(0, 0, (float) Math.PI,
                new Difference(
                        new Union(
                                new Difference(
                                        new Union(
                                                new Difference(
                                                        new Ellipse(7, 7),
                                                        new Intersection(
                                                                new Translated(3, 0, new Rectangle(6, 12)),
                                                                new Ellipse(6, 6)
                                                        )
                                                ),
                                                new Translated(0, 3, new Ellipse(3, 3))
                                        ),
                                        new Translated(0, -3, new Ellipse(3, 3))
                                ),
                                new Translated(0, -3, new Ellipse(1, 1))
                        ),
                        new Translated(0, 3, new Ellipse(1, 1))
                ));

        Shape test = new Difference(
                new Rotated(0, 0, (float) Math.PI / 6, new Ellipse(12, 8)),
                yy);
        
        Iterator i = test.interator();
        
        while(i.hasNext()) 
        {
            Shape s=i.next();
            System.out.println(s);
        }
    }
}
