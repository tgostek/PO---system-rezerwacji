/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomaszgostek
 */
public class QueryResult {
    List<Room> rooms;
    int price = 0;
    
    public QueryResult() {
        rooms = new ArrayList<Room>();
    }
    
    void add(Room room) {
        this.rooms.add(room);
    }

    List<Room> rooms() {
        return this.rooms;
    }
    
    void addPrice(int price) {
        this.price += price;
    }
    
    int price() {
        return this.price;
    }
}
