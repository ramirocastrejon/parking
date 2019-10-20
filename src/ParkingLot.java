import java.util.ArrayList;
import java.util.Random;

public class ParkingLot {
    private int maxCapacity = 10;
    private int parkingRate = 5;
    private static int currentCapacity;
    private static ArrayList<Ticket> listTickets= new ArrayList<Ticket>();
    private static ParkingLot parkingLot = null;
    private static int totalProfit;

    ParkingLot(){
        currentCapacity=0;
        totalProfit=0;
    }

    public static ParkingLot getParkingLot(){
        if(parkingLot==null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public boolean spotAvailable(){
        if(currentCapacity < maxCapacity)
            return true;
        else
            return false;
    }

    public void entry(Car car){//car
        if(spotAvailable()) {
            Ticket temp = new Ticket(car);
            listTickets.add(temp);
            currentCapacity++;
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
                        + listTickets.get(i).getExit() + " hours and pays "
                + newPayment.getAmountDue() );
                totalProfit+=newPayment.getAmountDue();
                currentCapacity--;
            }

        }


    }

    public int getTotalProfit(){
        return totalProfit;
    }
    public void setRate(int rate){
        parkingRate=rate;
    }

    public int getRate() {
        return parkingRate;
    }
}
