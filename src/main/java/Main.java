import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
	// write your code here
       /* System.out.println("This will be a parking lot model");
        Pay newPay = new Pay();
        newPay.setEntry();
        TimeUnit.SECONDS.sleep(5);
        newPay.setExit();;
        newPay.calculateAmountDue();;
        System.out.println("Amount due is : " + newPay.payAmountDue());*/

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
            System.out.print("What is the hourly rate for group " + lots + " ?");
            int newRate = sc.nextInt();
            ParkingLot newParkingLot = new ParkingLot(lots,newRate);
            allParkingLots.add(newParkingLot);
        }
        System.out.println("Created "+ allParkingLots.size() + " parking lots");
        for (int i = 0; i < allParkingLots.size(); i++) {
            System.out.println(allParkingLots.get(i).getRate());
        }

       // newParkingLot.setRate(rate);
        System.out.println("Current hourly rate: " + allParkingLots.get(0).getRate());
        System.out.println("Group: " + allParkingLots.get(0).getGroupID());
        for (int i=0; i<carList.size(); i++)
            allParkingLots.get(0).entry(carList.get(i));

        /*for (int i=0; i<carList.size(); i++)
            allParkingLots.get(1).exit(carList.get(i));

        System.out.println("Total profit: "+  allParkingLots.get(1).getTotalProfit());*/
        System.out.println("Current hourly rate: " + allParkingLots.get(1).getRate());
        System.out.println("Group: " + allParkingLots.get(1).getGroupID());
        for (int i=0; i<carList.size(); i++)
            allParkingLots.get(1).entry(carList.get(i));

        /*for (int i=0; i<carList.size(); i++)
            allParkingLots.get(0).exit(carList.get(i));*/
        for (int i=0; i<carList.size(); i++)
            allParkingLots.get(0).exit(carList.get(i));

        System.out.println("Total profit: "+  allParkingLots.get(1).getTotalProfit());
        //System.out.println("Total profit: "+  allParkingLots.get(1).getTotalProfit());



    }
}
