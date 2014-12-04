/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

import static java.lang.Math.pow;
/**
 *
 * @author tomaszgostek
 */
public class Ellipse implements Shape{
    public float a,b;
    public Ellipse(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean contains(float x, float y) {
        return ( pow(x,2)/pow(a,2) + pow(y,2)/pow(b,2) <= 1 ) ;
    }
    
}
