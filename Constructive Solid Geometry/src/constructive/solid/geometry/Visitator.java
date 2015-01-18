
package constructive.solid.geometry;


public interface Visitator
{
    public void visit(Difference shape);
    public void visit(Ellipse shape);
    public void visit(Intersection shape);
    public void visit(Rectangle shape);
    public void visit(Rotated shape);
    public void visit(Translated shape);
    public void visit(Union shape);
}
