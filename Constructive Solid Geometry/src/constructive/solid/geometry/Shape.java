/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructive.solid.geometry;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tomaszgostek
 */
public interface Shape{
    public boolean contains(float x, float y);
    public void accept(Visitor visitor, String text);
    public Iterator<Shape> iterator();
    public List<Shape> getChildren();
}

/*
Rectangle 
a_____
b|

Ellipse
a_____
b| - mniejsze


*/
