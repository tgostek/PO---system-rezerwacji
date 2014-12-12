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
    
    @Override
    public String visit(Difference shape)
    {
        return "Difference";
    }
    
    @Override
    public String visit(Ellipse shape)
    {
        return "Ellipse";
    }
    @Override
    public String visit(Rectangle shape)
    {
        return "Rectangle";
    }
    
    @Override
    public String visit(Intersection shape)
    {
        return "Intersection";
    }
    
    @Override
    public String visit(Union shape)
    {
        return "Union";
    }
    
    @Override
    public String visit(Rotated shape)
    {
       return "Rotated";
    }
    
    @Override
    public String visit(Translated shape)
    {
       return "Translated";
    }
}
