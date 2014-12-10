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
    public void visit(Difference shape, String text);
    public void visit(Ellipse shape, String text);
    public void visit(Intersection shape, String text);
    public void visit(Rectangle shape, String text);
    public void visit(Rotated shape, String text);
    public void visit(Translated shape, String text);
    public void visit(Union shape, String text);
    
}
