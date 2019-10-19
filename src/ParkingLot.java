import java.util.ArrayList;

public class ParkingLot {
    private int maxCapacity = 10;
    private double parkingRate = 5.00;
    private static ArrayList<Ticket> listTickets= new ArrayList<Ticket>();
    private double rate;
    private static ParkingLot parkingLot = null;

    ParkingLot(){

    }

    public static ParkingLot getParkingLot(){
        if(parkingLot==null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public void entry(Car car){//car
        Ticket temp = new Ticket(car);
        listTickets.add(temp);
        //System.out.println("\n" + temp.getEntry().toString() + "\n" + temp.getCar().getLicensePlate());

    }

    public void exit(){//car

    }
    public void setRate(double rate){
        this.rate=rate;
    }

}
