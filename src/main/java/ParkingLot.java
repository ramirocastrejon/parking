import java.util.ArrayList;
import java.util.Random;

public class ParkingLot {
    private int maxCapacity = 10;
    private int parkingRate;
    private int currentCapacity;
    private  ArrayList<Ticket> listTickets= new ArrayList<Ticket>();
    private static ArrayList<Car> carIsParked = new ArrayList<Car>();
    //private static ParkingLot parkingLot;
    private static int totalProfit;
    private int groupID;
    private int discount;
    private String policy;

    ParkingLot(int groupID, int rate){
        this.groupID = groupID;
        this.parkingRate=rate;
        this.discount = 0;
        currentCapacity=0;
        totalProfit=0;
    }

   /* public static ParkingLot getParkingLot(){
        return parkingLot;
    }*/

    public void setPolicy(String s){
        policy = s;
    }
    public int availableSpots(){
        return maxCapacity-currentCapacity;
    }

    public boolean isSpotAvailable(){
        if(currentCapacity < maxCapacity)
            return true;
        else
            return false;
    }

    public boolean isAlreadyParked(Car car){

        for(int j = 0; j <carIsParked.size();j++){
            if(carIsParked.get(j).getLicensePlate() ==car.getLicensePlate())
                return true;
        }
        return false;
    }

    public void entry(Car car){//car

        if(isSpotAvailable()) {
            if(!isAlreadyParked(car)) {
                Ticket temp = new Ticket(car, getGroupID());
                listTickets.add(temp);
                carIsParked.add(car);
                currentCapacity++;
            }
            else
                System.out.println("This car is already parked elsewhere. Cannot admit car.");
        }
        else
            System.out.println("The parking lot is currently full. Cannot admit car "
            + car.getLicensePlate());
        //System.out.println("\n" + temp.getEntry().toString() + "\n" + temp.getCar().getLicensePlate());

    }

    public void exit(Car car){//car
        for (int i=0; i<listTickets.size(); i++){
            if(listTickets.get(i).getCar().getLicensePlate()==car.getLicensePlate()){
                Random ran = new Random();
                int nxt = ran.nextInt(10) + 1;
                listTickets.get(i).setExit(nxt);
                Pay newPayment = new Pay();
                newPayment.calculateAmountDue(listTickets.get(i),parkingRate);
                System.out.println("Car: " + listTickets.get(i).getCar().getLicensePlate() + " spent "
                        + listTickets.get(i).getExit() + " hours in Parking Lot " +
                        listTickets.get(i).getGroupID()+ " and pays "
                + newPayment.getAmountDue() );
                totalProfit+=newPayment.getAmountDue();
                listTickets.remove(i);
                carIsParked.remove(i);
                currentCapacity--;
            }

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
}
