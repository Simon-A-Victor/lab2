import java.awt.*;

public class Scania extends Car{

    public Scania(double x, double y){
        super(2,250,Color.black,"Scania",x, y);
    }

    public double platformAngle = 0;

    public void tiltPlatform(int degrees){
        platformAngle += degrees;

        if (platformAngle > 70){
            platformAngle = 70;
        } else if (platformAngle < 0) {
            platformAngle = 0;
        }
    }
    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
