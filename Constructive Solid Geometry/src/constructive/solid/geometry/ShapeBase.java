
package constructive.solid.geometry;

import java.util.List;

public class ShapeBase implements Shape, Visitator
{

    @Override
    public boolean contains(float x, float y) {return false;}

    @Override
    public void accept(Visitator v) {}

    @Override
    public List getShapes() {return null;}

    @Override
    public void visit(Shape shape) {}

    @Override
    public Iterator interator() 
    {
        return new ShapeIterator(this);
    }
    
}
