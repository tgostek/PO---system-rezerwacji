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
public class Union implements Shape{
    private Shape shape1, shape2;
    
    public Union(Shape shape1, Shape shape2) {
        this.shape1 = shape1;
        this.shape2 = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        return ( shape1.contains(x, y) || shape2.contains(x, y) );
    }
    
}
