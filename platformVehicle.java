import java.awt.*;

abstract class platformVehicle extends Car {
    private double platformAngle = 0.0;

    public platformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    protected double getPlatformAngle(){
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees){
        platformAngle = degrees;
    }

    protected boolean platformIsDown(){
        return getPlatformAngle() == 0.0;
    }
}
