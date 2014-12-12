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
public interface Visitor
{
    public String visit(Difference shape);
    public String visit(Ellipse shape);
    public String visit(Intersection shape);
    public String visit(Rectangle shape);
    public String visit(Rotated shape);
    public String visit(Translated shape);
    public String visit(Union shape);
    
}
