/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tomaszgostek
 */
public class Hotel {
    
    List<Room> rooms;
    
    public Hotel() {
        rooms = new ArrayList<Room>();
    }
    
    List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons) {
        List<QueryResult> qr = new ArrayList<QueryResult>();
        
        int numberOfNights = Hotel.getCountOfNights(start, end);
        List<Room> emptyRooms = new ArrayList<Room>();
       
        for(Room room : this.rooms) {
            if(this.checkIfRoomIsEmpty(room, start, end)) {
                emptyRooms.add(room);
            }
        }
        
        for(Room room : emptyRooms) {
            if(room.n_persons() == n_persons) {
                QueryResult result = new QueryResult();
                result.add(room);
                result.addPrice(room.getPrice() * numberOfNights);
                
                qr.add(result);
            }
        }
        
        return qr;
    }
    
    void add(Room room) {
        rooms.add(room);
    }
    
    public static int getCountOfNights(Calendar start, Calendar end) { 
        Date d1 = start.getTime();
        Date d2 = end.getTime();
        
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    private boolean checkIfRoomIsEmpty(Room room, Calendar start, Calendar end) {
      return true;  
    };
}
