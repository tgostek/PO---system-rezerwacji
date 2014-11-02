package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Hotel {
    
    //private sector
    private final List<Room> rooms;
    
    private List<Room> getAllRoomsEqual(int p_numberOfPersons, List<Room> p_rooms)
    {
        List<Room> l_listRooms = new ArrayList<>();
        for(Room room : p_rooms)
            if(room.n_persons() == p_numberOfPersons)
                l_listRooms.add(room);
        return l_listRooms;
    }
    
    private List<Room> getAllRoomsAbove(int p_numberOfPersons)
    {
        List<Room> l_listRooms = new ArrayList<>();
        for(Room room : this.rooms)
            if(room.n_persons() > p_numberOfPersons)
                l_listRooms.add(room);
        return l_listRooms;
    }
    
    private void deleteAllRoomsAbove(int p_numberOfPersons, List<Room> p_listRooms)
    {
        for(int i = 0; i < p_listRooms.size();)
            if(p_numberOfPersons < p_listRooms.get(i).n_persons())
                p_listRooms.remove(p_listRooms.get(i));
            else
                i++;
    }
    
    private List<QueryResult> findAllPosibleCombination(int p_numberOfPersons)
    {
        List<QueryResult> l_qr = new ArrayList<>();
        
        List<Room> l_listRooms = getAllRoomsEqual(p_numberOfPersons, this.rooms);
        for(Room room : l_listRooms)
        {
            QueryResult qr = new QueryResult();
            qr.add(room);
            l_qr.add(qr);
        }
        
        l_listRooms = getAllRoomsAbove(p_numberOfPersons);
        for(Room room : l_listRooms)
        {
            QueryResult qr = new QueryResult();
            qr.add(room);
            l_qr.add(qr);
        }
        
        
        l_listRooms = new ArrayList<>(this.rooms);
        deleteAllRoomsAbove(p_numberOfPersons - 1, l_listRooms);
        
        Collections.sort(l_listRooms);
        
        for(int i = l_listRooms.size()-1; i >= 0; i = l_listRooms.size()-1)
        {  
            QueryResult l_tempQr = new QueryResult();
            l_tempQr.add(l_listRooms.get(i));
            for(int j = i-1; j >= 0; j--)
            {
                Room l_room = l_listRooms.get(j);
                    
                if(l_tempQr.n_person() + l_room.n_persons() == p_numberOfPersons)
                {
                    List<Room> ll_rooms = getAllRoomsEqual(l_room.n_persons(), l_listRooms);
                    for(Room room : ll_rooms)
                    {
                        if(l_tempQr.isRoom(room))
                        {
                            continue;
                        }
                        
                        QueryResult l_tempQr2 = new QueryResult();
                        l_tempQr2.add(room);
                        l_tempQr2.add(l_tempQr);
                        l_qr.add(l_tempQr2);
                    }
                    break;
                }
                
                if(l_tempQr.n_person() + l_room.n_persons() < p_numberOfPersons)
                {
                    l_tempQr.add(l_room);
                    continue;
                }
            }
            l_listRooms.remove(l_listRooms.get(i));   
        }
        
        return l_qr;
    }
    
    public static int getCountOfNights(Calendar start, Calendar end) { 
        Date d1 = start.getTime();
        Date d2 = end.getTime();
        
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    //public sector
    public Hotel() {
        rooms = new ArrayList<>();
    }
    
    public void add(Room room) {
        rooms.add(room);
    }
    
    private List<QueryResult> findCheapestFreeRooms(Calendar start, Calendar end, int n_persons)
    {
        List<QueryResult> l_qr = new ArrayList<>();
        l_qr = findAllPosibleCombination(n_persons);
        
        for(QueryResult qr : l_qr)
        {
            qr.setNights(getCountOfNights(start,end));
        }
        
        Collections.sort(l_qr);
        
        int cheapestPrice = l_qr.get(0).price();
        
        int index = l_qr.size();
        for(int i = 0; i < l_qr.size(); i++)
        {
            if(l_qr.get(i).price() == cheapestPrice)
                continue;
            else
            {
                index = i;
                break;
            }
        }
        
        l_qr = l_qr.subList(0, index);
        return l_qr;
    }
    
    public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons) {
        List<QueryResult> l_qr = new ArrayList<>();
        
        if(this.rooms.isEmpty())
            return l_qr;
        
        l_qr = findCheapestFreeRooms(start, end, n_persons);
            
        return l_qr;
    }
    
    public void reserve(Calendar start, Calendar end, QueryResult result, Person person) {
        List<Room> rooms = result.rooms();
        for (Room room : rooms) {
            room.reserve(start, end, person);
        }
    } 

}
