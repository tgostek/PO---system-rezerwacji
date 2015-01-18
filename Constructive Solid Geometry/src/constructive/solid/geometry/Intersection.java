
package constructive.solid.geometry;

public class Intersection implements Shape
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
    
    
}
