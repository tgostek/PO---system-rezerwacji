
package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TableOfSeasonPrices 
{
    private List<ItemSeasonPrices> tableOfSeasonPrices;
    
    public TableOfSeasonPrices()
    {
        this.tableOfSeasonPrices = new ArrayList<>();
    }
    
    public void addItemSeasonPrices(Calendar start, Calendar end, int procent)
    {
        // jesli sie naklada zwroc warning i nie dodawaj
        tableOfSeasonPrices.add(new ItemSeasonPrices(start, end, procent));
    }
    
    public int getSeasonProcentPrice(Calendar day)
    {
        if(tableOfSeasonPrices.isEmpty())
            return 0;
        //TODO
        return 0;
    }
    
    public class ItemSeasonPrices
    {
        private Calendar start;
        private Calendar end;
        private int procent;
        
        ItemSeasonPrices(Calendar start, Calendar end, int procent)
        {
            this.start = start;
            this.end = end;
            this.procent = procent;
        }
        
        public Calendar getStart(){
           return this.start;
       }
        
       public Calendar getEnd(){
           return this.end;
       }
       
       public int getProcent(){
           return this.procent;
       }
       
       @Override
        public String toString() {
            //TODO
            return "";
        }
    }
    
    @Override
    public String toString() {
        //TODO
        return "";
    }
}
