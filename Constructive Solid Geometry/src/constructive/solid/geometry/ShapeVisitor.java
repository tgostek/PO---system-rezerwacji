/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructive.solid.geometry;

/**
 *
 * @author sarka
 */
public class ShapeVisitor implements Visitor{
    
   
    public void visit(Difference shape, String text)
    {
        System.out.println(text + "Difference");
        shape.getShape1().accept(this, text + "\t");
        shape.getShape2().accept(this, text + "\t");
    }
    
    public void visit(Ellipse shape, String text)
    {
        System.out.println(text + "Ellipse");
    }
    public void visit(Rectangle shape, String text)
    {
        System.out.println(text + "Rectangle");
    }
    
    public void visit(Intersection shape, String text)
    {
        System.out.println(text + "Intersection");
        shape.getShape1().accept(this, text + "\t");
        shape.getShape2().accept(this, text + "\t");
    }
    
    public void visit(Union shape, String text)
    {
        System.out.println(text +  "Union");
        shape.getShape1().accept(this, text + "\t");
        shape.getShape2().accept(this, text + "\t");
    }
    
    
    public void visit(Rotated shape, String text)
    {
       System.out.println(text + "Rotated");
       shape.getShape().accept(this, text + "\t"); 
    }
    
    public void visit(Translated shape, String text)
    {
       System.out.println(text + "Translated");
       shape.getShape().accept(this, text + "\t");
    }
}
