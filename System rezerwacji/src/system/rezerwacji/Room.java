package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Room implements Comparable<Room>{
    
    private String name;
    private int n_persons;
    private int price;
    private List<Reservation> reservations;
    private static TableOfSeasonPrices tableOfSeasonPrices = new TableOfSeasonPrices();
    
    public static void setTableOfSeasonPrices(TableOfSeasonPrices tableOfSeasonPrices)
    {
        Room.tableOfSeasonPrices = tableOfSeasonPrices;
    }
    
    public Room(String name, int n_persons, int price) {
        this.name = name;
        this.n_persons = n_persons;
        this.price = price;
        this.reservations = new ArrayList<>();
    }
    
    String name() {
        return name;
    }
    
    int price(Calendar day) {
        return price + price * Room.tableOfSeasonPrices.getSeasonProcentPrice(day);
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
            Calendar s1 = reservation.getStart();
            Calendar e1 = reservation.getEnd();
            
            if(s1.before(start) && (e1.before(start) || e1.equals(start))) {
                continue;
            }
            if(e1.after(end) && (s1.after(end) || s1.equals(end))) {
                continue;
            }
            return false;
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
       
       @Override
        public String toString() {
            //TODO
            return "";
        }
    }
}
