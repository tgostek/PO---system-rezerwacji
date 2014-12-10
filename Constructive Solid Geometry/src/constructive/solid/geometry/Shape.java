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
public interface Shape {
    public boolean contains(float x, float y);
    public void accept(Visitor visitor, String text);
}

/*
Rectangle 
a_____
b|

Ellipse
a_____
b| - mniejsze


*/
