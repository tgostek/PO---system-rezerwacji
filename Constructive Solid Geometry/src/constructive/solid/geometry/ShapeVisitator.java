
package constructive.solid.geometry;

public class ShapeVisitator implements Visitator
{
    private String tabs = "";
    
    @Override
    public void visit(Difference shape) 
    {
        System.out.println(this.tabs + "Difference");
        this.tabs += "\t";
        String tabs = this.tabs;
        shape.getShape1().accept(this);
        this.tabs = tabs;
        shape.getShape2().accept(this);
    }

    @Override
    public void visit(Ellipse shape) 
    {
        System.out.println(tabs + "Ellipse");
    }

    @Override
    public void visit(Intersection shape) 
    {
        System.out.println(this.tabs + "Intersection");
        this.tabs += "\t";
        String tabs = this.tabs;
        shape.getShape1().accept(this);
        this.tabs = tabs;
        shape.getShape2().accept(this);
    }

    @Override
    public void visit(Rectangle shape) 
    {
        System.out.println(this.tabs + "Rectangle");
    }

    @Override
    public void visit(Rotated shape) 
    {
        System.out.println(this.tabs + "Rotated");
        this.tabs += "\t";
        String tabs = this.tabs;
        shape.getShape().accept(this);
        this.tabs = tabs;
    }

    @Override
    public void visit(Translated shape) 
    {
        System.out.println(this.tabs + "Translated");
        this.tabs += "\t";
        String tabs = this.tabs;
        shape.getShape().accept(this);
        this.tabs = tabs;
    }

    @Override
    public void visit(Union shape) 
    {
        System.out.println(this.tabs + "Union");
        this.tabs += "\t";
        String tabs = this.tabs;
        shape.getShape1().accept(this);
        this.tabs = tabs;
        shape.getShape2().accept(this);
    }
    
    
}
