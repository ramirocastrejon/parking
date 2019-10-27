import java.sql.Time;
import java.sql.Timestamp;


public class Ticket {
    private int entry;
    private int exit;
    private int groupID;
    private Car car;

    public  Ticket(Car car, int id){
        this.car = car;
        groupID = id;
        setEntry();;
    }

    public int getGroupID(){ return groupID;}

    public Car getCar(){
        return car;
    }

    public void setEntry(){
        entry = 0;
    }

    public int getEntry(){
        return entry;
    }

    public void setExit(int hoursExpanded){
        exit = hoursExpanded;
    }

    public int getExit(){
        return exit;
    }
}
