public class Car implements Vehicle {
    private String licensePlate;


    public Car(String lp){
        this.licensePlate=lp;

    }
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
    //if we need to differentiate between sizes of vehicles in future updates
    @Override
    public int getSize() {
        return 1;
    }
}
