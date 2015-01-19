package constructive.solid.geometry;

import java.util.List;

interface Shape
{
    boolean contains(float x, float y);
    void accept(Visitator v);
    
    Iterator interator();
    
    List getShapes();

}