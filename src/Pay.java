import java.time.Period;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Pay extends Ticket{
    private double amountDue;
    private double rate;

    public void setRate(double rate){
        this.rate=rate;
    }

    public void calculateAmountDue(){
        amountDue = SECONDS.between(getEntry(),getExit());
    }

    public double payAmountDue(){
        return amountDue;
    }
}
