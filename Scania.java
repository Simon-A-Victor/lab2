import java.awt.*;

public class Scania extends Car{

    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 250;
        modelName = "Scania";
        stopEngine();
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
