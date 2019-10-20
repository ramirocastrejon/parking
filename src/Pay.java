import java.time.Period;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Pay {
    private double amountDue;
    private double rate;



    public double calculateAmountDue(Ticket ticket, double rate){

        return amountDue = ticket.getExit() * rate;
    }

    public double getAmountDue(){
        return amountDue;
    }
}
