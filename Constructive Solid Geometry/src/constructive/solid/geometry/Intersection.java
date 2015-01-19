
package constructive.solid.geometry;

import java.util.ArrayList;
import java.util.List;

public class Intersection extends ShapeBase
{
    private Shape shape1, shape2;
    
    Shape getShape1(){return this.shape1;}
    Shape getShape2(){return this.shape2;}
    
    public Intersection(Shape shape1, Shape shape2) {
        this.shape1 = shape1;
        this.shape2 = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        boolean isContains = ( shape1.contains(x, y) && shape2.contains(x, y) );
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
        return "Intersection";
    }

    @Override
    public List getShapes() 
    {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(this.shape1);
        shapes.add(this.shape2);
        return shapes;
    }
}
