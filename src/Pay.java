import java.time.Period;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Pay{
    private double amountDue;
    private double rate;



    public void calculateAmountDue(Ticket ticket, double rate){

        amountDue = SECONDS.between(ticket.getEntry(),ticket.getExit()) * rate;
    }

    public double payAmountDue(){
        return amountDue;
    }
}
