
import java.awt.*;



abstract class Car extends Vehicle implements Movable, Loadable {

    private int nrDoors; // Number of doors on the car

    public Car(int nrDoors, Color color, String modelName, double x, double y, int size, double enginePower){
        super(color, modelName, x, y, size, enginePower);
        this.nrDoors = nrDoors;
        this.stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public void startEngine(){
         this.setActive();
         this.setCurrentSpeed(0.1);

    }

    public void stopEngine(){
        this.setCurrentSpeed(0.0);
    }

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
