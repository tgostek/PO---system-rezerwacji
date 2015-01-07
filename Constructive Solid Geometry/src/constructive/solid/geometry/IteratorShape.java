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
public class IteratorShape implements Iterator {
    
    private List<Shape> listShape = new ArrayList();
    
    public IteratorShape(Shape shape) {
        this.listShape = shape.getChildren();
    }
    @Override
    public boolean hasNext() {
        return (this.listShape.size() > 0);
    }

    @Override
    public Object next() {
        Shape shape = this.listShape.get(0);
        this.listShape.addAll(shape.getChildren());
        this.listShape.remove(0);
        return shape;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
