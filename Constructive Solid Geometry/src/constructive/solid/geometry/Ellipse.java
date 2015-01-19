
package constructive.solid.geometry;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

public class Ellipse extends ShapeBase
{
    private float a,b;
    
    public Ellipse(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean contains(float x, float y) {
        boolean isContains = ( pow(x,2)/pow(a,2) + pow(y,2)/pow(b,2) <= 1 ) ;
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
        return "Ellipse(" + this.a + ", " + this.b + ")";
    }

    @Override
    public List getShapes() 
    {
        List<Shape> shapes = new ArrayList<>();
        return shapes;
    }
}
