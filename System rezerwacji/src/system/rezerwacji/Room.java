/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tomaszgostek
 */
public class Room {
    
    List<Calendar> reservations;
    
    String name;
    int n_persons;
    int price;
    
    public Room(String name, int n_persons, int price) {
        reservations = new ArrayList<Calendar>();
        this.name = name;
        this.n_persons = n_persons;
        this.price = price;
    }
    
    String name() {
        return name;
    }
    
    int getPrice() {
        return price;
    }
    
    int n_persons() {
        return n_persons;
    }
}
