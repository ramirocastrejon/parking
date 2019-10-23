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

        ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.setRate(rate);
        System.out.println("Current hourly rate: " + newParkingLot.getRate());
        for (int i=0; i<carList.size(); i++)
            newParkingLot.entry(carList.get(i));

        for (int i=0; i<carList.size(); i++)
            newParkingLot.exit(carList.get(i));

        System.out.println("Total profit: "+  newParkingLot.getTotalProfit());

    }
}
