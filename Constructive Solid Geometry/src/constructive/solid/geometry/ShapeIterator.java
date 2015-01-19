
package constructive.solid.geometry;

import java.util.*;

class ShapeIterator implements Iterator 
{

    List<Shape> shapes = new ArrayList<>();
    
    public ShapeIterator(Shape shape) 
    {
        this.shapes.add(shape);
        this.shapes.addAll(shape.getShapes());
    }

    @Override
    public boolean hasNext() 
    {
        if(this.shapes.size() > 1) return true;
        if(this.shapes.get(0).getShapes().size() > 0) return true;
        return false;
    }

    @Override
    public Shape next() 
    {
        Shape shape = this.shapes.get(0);
        this.shapes.remove(0);
        this.shapes.addAll(1,this.shapes.get(0).getShapes());
        return shape;
    }
    
}
