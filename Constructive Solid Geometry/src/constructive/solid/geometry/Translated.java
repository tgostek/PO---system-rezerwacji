/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tomaszgostek
 */
public class Translated implements Shape{
    
    private List<Shape> children = new ArrayList();
    private Shape shape;
    private float x, y;
    
    Shape getShape(){return this.shape;}
    
    public Translated(float x, float y, Shape shape) {
        this.children.add(shape); 
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
    public String toString() {
        return "Translated(" + this.x + "," + this.y + ","  + this.shape+ ")";
    }

    @Override
    public void accept(Visitor visitor, String text) {
        System.out.println(text + visitor.visit(this));
        
        getShape().accept(visitor, text + "\t");
    }

    @Override 
    public Iterator<Shape> iterator() {
        return new IteratorShape(this);
    }

    @Override
    public List<Shape> getChildren() {
        return this.children;
    }
}
