import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ParkingLot {
    private int maxCapacity;
    private int parkingRate;
    private int currentCapacity;
    private static HashMap<String,Ticket> activeTickets = new HashMap<String, Ticket>();
    private static int totalProfit;
    private int groupID;
    private int discount;
    private String policy;

    ParkingLot(int groupID, int capacity, int rate, int discount){
        this.groupID = groupID;
        maxCapacity=capacity;
        this.parkingRate=rate;
        if(discount > rate)
            this.discount = 0;
        else
            this.discount=discount;
        currentCapacity=0;
        totalProfit=0;
    }

    ParkingLot(){}

   /* public static ParkingLot getParkingLot(){
        return parkingLot;
    }*/

    public void setPolicy(String s){
        policy = s;
    }
    public int availableSpots(){
        return maxCapacity-currentCapacity;
    }

    public boolean isCarParkedHere(Car car){
        return activeTickets.containsKey(car.getLicensePlate());
    }

    public boolean isSpotAvailable(){
        if(currentCapacity < maxCapacity)
            return true;
        else
            return false;
    }


    public void entry(Car car){//car

        if(isSpotAvailable()) {
            if(!isCarParkedHere(car)) {
                Ticket temp = new Ticket(car, getGroupID(),parkingRate,discount);
                activeTickets.put(car.getLicensePlate(),temp);
                currentCapacity++;
            }
            else
                System.out.println("This car is already parked elsewhere. Cannot admit car.");
        }
        else
            System.out.println("The parking lot is currently full. Cannot admit car "
            + car.getLicensePlate());


    }

    public void exit(Car car){//car

        if(activeTickets.containsKey(car.getLicensePlate())){
            Random ran = new Random();
            int nxt = ran.nextInt(10) + 1;
            Ticket temp = activeTickets.get(car.getLicensePlate());
            temp.setExit(nxt);
            Pay newPayment = new Pay();
            newPayment.calculateAmountDue(temp);
            System.out.println("Car " + car.getLicensePlate() + " spent " + nxt + " hours in parking lot "
            + temp.getGroupID() + " with an hourly rate of " + temp.getRate() + " and pays " +
                    newPayment.getAmountDue());
            totalProfit+=newPayment.getAmountDue();
            activeTickets.remove(car.getLicensePlate());
            currentCapacity--;
        }


    }
    public void setDiscount(int discount){ this.discount = discount;}

    public int getTotalProfit(){
        return totalProfit;
    }

    public int getRate() {
        return parkingRate;
    }
    public int getGroupID(){return groupID;}

    public void getAllActiveTickets(){
        for (String i : activeTickets.keySet()) {
            System.out.println(i);
        }
    }

    public int getDiscount() {
        return discount;
    }
}
