import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
	// write your code here

        ArrayList<Car> carList = new ArrayList<Car>();
        //file can be test1.txt - test5.txt
        File file = new File("src", "test2.txt");
        Scanner scanner = new Scanner(file);
        String read =scanner.next();
        int rate = parseInt(read);
        while (scanner.hasNext()) {
            String readCar =scanner.next();
            Car temp = new Car(readCar);
            carList.add(temp);
        }
        scanner.close();

        Scanner sc = new Scanner(System.in);
        System.out.print("How many groups are there?: ");
        int groups = sc.nextInt();

        ArrayList<ParkingLot> allParkingLots = new ArrayList<ParkingLot>();
        for(int lots = 0; lots <groups; lots++){
            System.out.println("What is the maximum capacity of lot " + lots + " ?");
            int newCapacity = sc.nextInt();
            System.out.print("What is the hourly rate for lot " + lots + " ?");
            int newRate = sc.nextInt();
            System.out.println("What is this lot's flat discount ?");
            int newDiscount = sc.nextInt();
            ParkingLot newParkingLot = new ParkingLot(lots,newCapacity,newRate,newDiscount);
            allParkingLots.add(newParkingLot);
        }
        System.out.println("Created "+ allParkingLots.size() + " parking lots");


        ParkingLotManager lotManager = new ParkingLotManager();
        lotManager.getAllRatesAndDisc(allParkingLots);
        for (int i=0; i<carList.size(); i++) {
            ParkingLot lowest = lotManager.getLowestRate(allParkingLots);
            System.out.println("Car " +carList.get(i).getLicensePlate() + " chose Parking Lot " +
                    lowest.getGroupID() + " with a rate of " + lowest.getRate());
            lowest.entry(carList.get(i));
        }
        lotManager.getAllAvailableSpots(allParkingLots);

        lotManager.exitAllCars(allParkingLots,carList);

        System.out.println("Total profit: "+  allParkingLots.get(1).getTotalProfit());

    }
}
