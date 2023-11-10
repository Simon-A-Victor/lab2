import java.awt.*;

public class Scania extends Car {

    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y);
    }

    private double platformAngle = 0;

    public double getPlatformAngle(){
        return platformAngle;
    }

    private void setPlatformAngle(double degrees){
        platformAngle = degrees;
    }

    public void tiltPlatform(int degrees) {
        if(this.isStationary()){
            this.setPlatformAngle(this.getPlatformAngle() + degrees);

            if (this.getPlatformAngle() > 70) {
                this.setPlatformAngle(70);
            } else if (this.getPlatformAngle() < 0) {
                this.setPlatformAngle(0);
            }
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public void gas(double amount){
        if (0 <= amount && amount <= 1 && getPlatformAngle() == 0){
            this.incrementSpeed(amount);
        }
    }

}
