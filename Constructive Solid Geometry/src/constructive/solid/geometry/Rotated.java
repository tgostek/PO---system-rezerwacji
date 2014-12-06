/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;

/**
 *
 * @author tomaszgostek
 */
public class Rotated implements Shape{
    
    private Shape shape;
    private float x, y, angle;
    
    public Rotated(float x, float y, float angle, Shape shape) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        
        this.shape = shape;
    }

    @Override
    public boolean contains(float x, float y) {
        
        float x2 = (float) ((x - this.x) * cos(-angle) - (y - this.y) * sin(-angle));
        float y2 = (float) ((x - this.x) * sin(-angle) + (y - this.y) * cos(-angle));
        
        boolean isContains = shape.contains(x2, y2);
        System.out.println("Punkt:" + x + " " + y + "    " + isContains + "   " + this);
        return isContains;
    }
    
    @Override
    public String toString() {
        return "Rotated(" + this.x + "," + this.y + "," + this.angle + "," + this.shape+ ")";
    }
}
