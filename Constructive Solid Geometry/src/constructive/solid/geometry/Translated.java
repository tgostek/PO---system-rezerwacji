
package constructive.solid.geometry;

import java.util.ArrayList;
import java.util.List;

public class Translated extends ShapeBase
{    
    private Shape shape;
    private float x, y;
    
    Shape getShape(){return this.shape;}
    
    public Translated(float x, float y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
    }
    
    @Override
    public boolean contains(float x, float y) {
        boolean isContains = shape.contains(x - this.x, y - this.y);
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
        return "Translated(" + this.x + ", " + this.y  + ")";
    }

    @Override
    public List getShapes() 
    {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(this.shape);
        return shapes;
    }
}
