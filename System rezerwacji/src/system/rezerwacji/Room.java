
package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Room implements Comparable<Room>{
    
    private String name;
    private int n_persons;
    private int price;
    
    public Room(String name, int n_persons, int price) {
        this.name = name;
        this.n_persons = n_persons;
        this.price = price;
    }
    
    String name() {
        return name;
    }
    
    int price() {
        return price;
    }
    
    int n_persons() {
        return n_persons;
    }
    
    @Override
    public String toString() {
        return "Room \'" +  this.name + 
               "\' for " + this.n_persons + 
               " costs: " + this.price + " EUR.";
    }
    
    @Override
    public int compareTo(Room room) {
        Integer myNPerson = this.n_persons;
        Integer oNPerson = room.n_persons();
        return myNPerson.compareTo(oNPerson);
    }
    
    
}
