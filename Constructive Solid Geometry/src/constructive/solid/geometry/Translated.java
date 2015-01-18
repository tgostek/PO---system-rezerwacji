
package constructive.solid.geometry;

public class Translated implements Shape{
    
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
        System.out.println("Punkt:" + x + " " + y + "    " + isContains + "   " + this);
        return isContains;
    }

    @Override
    public void accept(Visitator v) 
    {
        v.visit(this);
    }
}
