import java.util.ArrayList;

public class ParkingLotManager {

    public ParkingLot getLowestRate(ArrayList<ParkingLot> lots){
        int i =1;
        ParkingLot lowestRate = lots.get(0);
        while(i < lots.size()){

            if(lowestRate.getRate() > lots.get(i).getRate() && lots.get(i).isSpotAvailable())
                lowestRate=lots.get(i);
            if(lowestRate.isSpotAvailable() == false)
                lowestRate=lots.get(i);
            i++;
        }

        return lowestRate;
    }

    public void getAllRatesAndDisc(ArrayList<ParkingLot> lots){
        for(int i = 0; i < lots.size(); i++){
            System.out.println("Group " + lots.get(i).getGroupID() +
                    " has an hourly rate of " + lots.get(i).getRate() +
                    " with a flat discount of " + lots.get(i).getDiscount());
        }
    }

    public void getAllAvailableSpots(ArrayList<ParkingLot> lots){
        for (int i = 0; i < lots.size(); i++) {
            System.out.println("Group " + lots.get(i).getGroupID() +
                    " has " + lots.get(i).availableSpots() + " available spots.");
        }
    }

    public void exitAllCars(ArrayList<ParkingLot> lots, ArrayList<Car> carList){
        for (int i = 0; i < lots.size(); i++) {
            for (int j=0; j<carList.size(); j++)
                lots.get(i).exit(carList.get(j));
        }
    }
}
