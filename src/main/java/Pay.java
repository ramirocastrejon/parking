

public class Pay {
    private double amountDue;



    public double calculateAmountDue(Ticket ticket){

        return amountDue = (ticket.getExit() * ticket.getRate()) - ticket.getDiscount();
    }

    public double getAmountDue(){
        return amountDue;
    }
}
