import java.awt.*;

public class Scania extends Car{

    public Scania(double x, double y){
        super(2,250,Color.black,"Scania",x, y);
    }
    @Override
    double speedFactor() {
        return 0;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
