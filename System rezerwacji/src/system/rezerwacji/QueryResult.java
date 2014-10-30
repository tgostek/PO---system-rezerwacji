package system.rezerwacji;

import java.util.ArrayList;
import java.util.List;

public class QueryResult implements Comparable<QueryResult>{
    
    //private section
    private List<Room> rooms;
    private int nights;
    
    //public section
    public QueryResult() {
        this.rooms = new ArrayList<>();
        this.nights = 0;
    }
    
    public boolean isRoom(Room room)
    {
        if(-1 == rooms.indexOf(room))
        {
            return false;
        }
        return true;
    }
    
    public void add(Room room) {
        this.rooms.add(room);
    }
    
    public void add(QueryResult qr) {
        for(Room room : qr.rooms())
        {
            this.add(room);
        }
    }
    
    public void setNights(int nights){
        this.nights = nights;
    }
    
    public List<Room> rooms() {
        return this.rooms;
    }
    
    public int price() {
        int price = 0;
        for(Room room : this.rooms)
        {
            price += room.price() * this.nights;
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
