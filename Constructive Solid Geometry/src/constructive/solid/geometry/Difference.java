/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

/**
 *
 * @author tomaszgostek
 */
public class Difference implements Shape{
    
    private Shape shape1, shape2;
    
    Shape getShape1(){return this.shape1;}
    Shape getShape2(){return this.shape2;}
    
    public Difference(Shape shape1, Shape shape2) {
        this.shape1 = shape1;
        this.shape2 = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        boolean isContains = (shape1.contains(x, y) && !shape2.contains(x, y));
        System.out.println("Punkt:" + x + " " + y + "    " + isContains + "   " + this);
        return isContains;
    }
    
    @Override
    public String toString() {
        return "Difference(" + this.shape1 + "," + this.shape2 + ")";
    }

    @Override
    public void accept(Visitor visitor, String text) {
        visitor.visit(this, text);
    }
    
}
