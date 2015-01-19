
package constructive.solid.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.List;

public class Rotated extends ShapeBase
{
    private Shape shape;
    private float x, y, angle;
    
    Shape getShape(){return this.shape;}
    
    public Rotated(float x, float y, float angle, Shape shape) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        
        this.shape = shape;
    }

    @Override
    public boolean contains(float x, float y) {
        
        float x2 = (float) ((x - this.x) * cos(-angle) - (y - this.y) * sin(-angle));
        float y2 = (float) ((x - this.x) * sin(-angle) + (y - this.y) * cos(-angle));
        
        boolean isContains = shape.contains(x2, y2);
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
        return "Rotated(" + this.x + ", " + this.y + ", " + this.angle + ")";
    }

    @Override
    public List getShapes() 
    {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(this.shape);
        return shapes;
    }
}
