import java.awt.*;
import java.util.Stack;

abstract class PlatformVehicle extends Car implements Loader {
    private double platformAngle = 0.0;
    private int maxSize;
    private int capacity;
    private Stack<Loadable> loaded;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size, int maxSize, int capacity) {
        super(nrDoors, enginePower, color, modelName, x, y, size);
        this.maxSize = maxSize;
        this.capacity = capacity;
        this.loaded  = new Stack<Loadable>();
    }

    protected double getPlatformAngle(){
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees){
        platformAngle = degrees;
    }

    protected boolean platformIsUp(){
        return getPlatformAngle() == 0.0;
    }

    @Override
    public void gas(double amount){
        if (0 <= amount && amount <= 1 && platformIsUp()){
            this.incrementSpeed(amount);
        }
    }

    @Override
    public int getMaxSize(){return maxSize;}

    @Override
    public int getCapacity(){return capacity;}

    public void placeDown(){

    }

    @Override
    public void load(Loadable other) {
        this.loaded.push(other);
    }

    @Override
    public void unload() {
        Loadable unloaded = this.loaded.pop();

    }

}
