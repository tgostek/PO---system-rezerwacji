package constructive.solid.geometry;

interface Shape 
{
    boolean contains(float x, float y);
    void accept(Visitator v);

}