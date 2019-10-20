import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

public class Ticket {
    private int entry;
    private int exit;
    private Car car;

    public  Ticket(Car car){
        this.car = car;
        setEntry();;
    }

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
