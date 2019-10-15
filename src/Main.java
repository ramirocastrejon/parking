import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.out.println("This will be a parking lot model");
        Pay newPay = new Pay();
        newPay.setEntry();
        TimeUnit.SECONDS.sleep(5);
        newPay.setExit();;
        newPay.calculateAmountDue();;
        System.out.println("Amount due is : " + newPay.payAmountDue());
    }
}
