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
public class Translated implements Shape{
    
    private Shape shape;
    private float x, y;
    
    public Translated(float x, float y, Shape shape) {
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
}
