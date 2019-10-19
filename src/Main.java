import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

        ArrayList<Car> carList = new ArrayList<>();
        File file = new File("src","test1.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String read =scanner.next();
            Car temp = new Car(read);
            carList.add(temp);
        }

        scanner.close();
        for (int i=0; i<carList.size(); i++)
            System.out.print(carList.get(i).getLicensePlate()+" ");
        ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.entry(carList.get(0));

    }
}
