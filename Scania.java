import java.awt.*;

public class Scania extends Car{

    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 250;
        modelName = "Scania";
        stopEngine();
    }

    public double flakVinkelGrader = 0;

    public void changeFlak(int grader){
        flakVinkelGrader += grader;

        if (flakVinkelGrader > 70){
            flakVinkelGrader = 70;
        } else if (flakVinkelGrader < 0) {
            flakVinkelGrader = 0;
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
