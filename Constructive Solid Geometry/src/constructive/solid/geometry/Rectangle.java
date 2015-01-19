
package constructive.solid.geometry;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends ShapeBase
{
    private float a,b;
    
    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean contains(float x, float y) {
        boolean isContains = ( ( (-a/2) <= x && x <= (a/2) ) && ( (-b/2) <= y && y <= (b/2) ) );
        return isContains;
    }

    @Override
    public void accept(Visitator v) 
    {
        v.visit(this);
    }
    
    @Override
    public String toString() 
    {
        return "Rectangle(" + this.a + ", " + this.b + ")";
    }

    @Override
    public List getShapes() 
    {
        List<Shape> shapes = new ArrayList<>();
        return shapes;
    }
}
