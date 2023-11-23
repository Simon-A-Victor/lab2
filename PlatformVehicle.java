import java.awt.*;

abstract class PlatformVehicle extends MotorVehicle {
    private double platformAngle = 0.0;
    private int nrDoors;
    private double enginePower;
    private boolean loaded;
    private int size;


    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(color, modelName, x, y, size, enginePower);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.loaded = false;
        this.size = size;

    }

    protected double getPlatformAngle() {
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees) {
        if (getPlatformAngle() == 0){
            platformAngle = degrees;
        }
    }

    protected boolean platformIsUp() {
        return getPlatformAngle() == 0.0;
    }
}
