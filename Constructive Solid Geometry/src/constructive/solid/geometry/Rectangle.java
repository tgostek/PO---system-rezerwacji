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
public class Rectangle implements Shape {
    private float a,b;
    private List<Shape> children = new ArrayList();
    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean contains(float x, float y) {
        boolean isContains = ( ( (-a/2) <= x && x <= (a/2) ) && ( (-b/2) <= y && y <= (b/2) ) );
        System.out.println("Punkt:" + x + " " + y + "    " + isContains + "   " + this);
        return isContains;
    }
    
    @Override
    public String toString() {
        return "Rectangle(" + this.a + "," + this.b + ")";
    }

    @Override
    public void accept(Visitor visitor, String text) {
        System.out.println(text + visitor.visit(this));
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
