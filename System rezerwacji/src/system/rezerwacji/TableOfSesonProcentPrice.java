
package system.rezerwacji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TableOfSesonProcentPrice 
{
    private List<Record> records;
    
    public TableOfSesonProcentPrice()
    {
        this.records = new ArrayList<>();
    }
    
    public void addIRecord(Calendar start, Calendar end, int procent)
    {
        // jesli sie naklada zwroc warning i nie dodawaj
        records.add(new Record(start, end, procent));
    }
    
    public int getSeasonProcentPrice(Calendar day)
    {
        
        if(records.isEmpty())
            return 0;
        
        for(Record record : this.records)
        {
            
            if(day.before(record.getStart()) || day.after(record.getEnd()) || day.equals(record.getEnd()))
            {
                continue;
            }
            
            
            return record.getProcent();
        }
        return 0;
    }
    
    public class Record
    {
        private Calendar start;
        private Calendar end;
        private int procent;
        
        Record(Calendar start, Calendar end, int procent)
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
