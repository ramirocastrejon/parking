import java.sql.Time;
import java.sql.Timestamp;


public class Ticket {
    private int entry;
    private int exit;
    private int groupID;
    private int rate;
    private Car car;
    private int discount;

    public  Ticket(Car car, int id, int rate, int discount){
        this.car = car;
        groupID = id;
        this.rate = rate;
        this.discount = discount;
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

    @Override
    public String toString(){
        return String.format("Car " + car.getLicensePlate() + "Group: " + getGroupID());
    }

    public int getRate() {
        return rate;
    }

    public int getDiscount() {
        return discount;
    }
}
