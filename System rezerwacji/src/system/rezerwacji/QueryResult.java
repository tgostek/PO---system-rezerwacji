package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class QueryResult implements Comparable<QueryResult>{
    
    //private section
    private List<Room> rooms;
    private Calendar start;
    private Calendar end;
    
    
    //public section
    public QueryResult() {
        this.rooms = new ArrayList<>();
        this.start = new GregorianCalendar(0, 0, 0);
        this.end = new GregorianCalendar(0, 0, 0);
    }
    
    public void add(Room room) {
        this.rooms.add(room);
    }
    
    public void setTime(Calendar start, Calendar end){
        this.start = start;
        this.end = end;
    }
    
    public List<Room> rooms() {
        return this.rooms;
    }
    
    public int price() {
        int price = 0;
        for(Room room : this.rooms)
        {
            for(Calendar day = new GregorianCalendar(this.start.get(Calendar.YEAR), 
                                                     this.start.get(Calendar.MONTH), 
                                                     this.start.get(Calendar.DAY_OF_MONTH));
                                    false == day.equals(this.end); 
                                    day.add(Calendar.DATE, 1))
            {
                price += room.price(day);
            }
        }
        
        return price;
    }
    
    public int n_person(){
        int n_person = 0;
        for(Room room : this.rooms)
            n_person += room.n_persons();
        return n_person;
    }
    
    @Override
    public String toString() {
        String l_result = "";
        for(Room room : this.rooms)
            l_result += room + "\n";
        l_result += "Total: " + this.rooms.size() + " rooms for " + this.price() + " EUR.";
        return l_result;
    }
    
    @Override
    public int compareTo(QueryResult qr) {
        Integer myNPrice = this.price();
        Integer oNPrice = qr.price();
        return myNPrice.compareTo(oNPrice);
    }
}
