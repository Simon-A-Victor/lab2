import java.awt.*;

abstract class PlatformVehicle extends Car implements Loader {
    private double platformAngle = 0.0;
    private int maxSize;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size, int maxSize) {
        super(nrDoors, enginePower, color, modelName, x, y, size);
        this.maxSize = maxSize;
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

    public int getMaxSize(){return maxSize;}

    @Override
    public void load(Loadable other) {

    }

    @Override
    public void unload() {

    }

}
