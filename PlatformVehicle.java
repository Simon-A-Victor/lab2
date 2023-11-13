import java.awt.*;

abstract class PlatformVehicle extends Car {
    private double platformAngle = 0.0;

    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(nrDoors, enginePower, color, modelName, x, y, size);
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

}
