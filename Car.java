
import java.awt.*;



abstract class Car extends Vehicle implements Movable, Loadable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car

    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size){
        super(color, modelName, x, y, size);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public void startEngine(){
         this.setActive();
         this.setCurrentSpeed(0.1);

    }

    public void stopEngine(){
        if (getCurrentSpeed() == 0) {
            this.setInactive();
        }
    }

    abstract double speedFactor();

    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            this.incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }
}
