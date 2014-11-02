
package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Room implements Comparable<Room>{
    
    private String name;
    private int n_persons;
    private int price;
    private final List<Reservation> reservations;
    
    public Room(String name, int n_persons, int price) {
        this.name = name;
        this.n_persons = n_persons;
        this.price = price;
        reservations = new ArrayList<>();
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
    
    public void reserve(Calendar start, Calendar end, Person person) {
        Reservation reservation = new Reservation(start, end, person);
        this.reservations.add(reservation);
    }
    
    public boolean isFree(Calendar start, Calendar end) {
        for (Reservation reservation : this.reservations) {
            if ( !(start.compareTo(reservation.getStart()) < 0 && start.compareTo(reservation.getEnd()) < 0)   
               || !(end.compareTo(reservation.getStart()) > 0 && end.compareTo(reservation.getEnd()) > 0) ) {
                return false;
            }
        }
        return true;
    }
    
    private class Reservation {
       private Calendar start;
       private Calendar end;
       private Person person;
       
       public Reservation(Calendar start, Calendar end, Person person){
           this.start = start;
           this.end = end;
           this.person = person;
       }
       
       public Calendar getStart(){
           return this.start;
       }
       public Calendar getEnd(){
           return this.end;
       }
    }
}
