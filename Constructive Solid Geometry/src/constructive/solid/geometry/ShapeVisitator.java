
package constructive.solid.geometry;

import java.util.List;

public class ShapeVisitator implements Visitator
{
    private String tabs = "";
    
    @Override
    public void visit(Shape shape) 
    {
        System.out.println(this.tabs + shape);
        
        this.tabs += "\t";
        String tabs = this.tabs;
        
        List<Shape> shapes = shape.getShapes();
        for(Shape child : shapes)
        {
            child.accept(this);
            this.tabs = tabs;
        }
    }
}
