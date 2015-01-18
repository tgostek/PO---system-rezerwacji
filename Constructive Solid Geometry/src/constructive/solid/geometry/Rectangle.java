
package constructive.solid.geometry;

public class Rectangle implements Shape 
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
}
