/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author tomaszgostek
 */
public class Ellipse implements Shape{
    private List<Shape> children = new ArrayList();
    public float a,b;
    public Ellipse(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean contains(float x, float y) {
        boolean isContains = ( pow(x,2)/pow(a,2) + pow(y,2)/pow(b,2) <= 1 ) ;
        System.out.println("Punkt:" + x + " " + y + "    " + isContains + "   " + this);
        return isContains;
    }
    
    @Override
    public String toString() {
        return "Elipse(" + this.a + "," + this.b + ")";
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
