import java.awt.*;

public class Scania extends platformVehicle {

    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y);
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
        if (0 <= amount && amount <= 1 && platformIsUp()){
            this.incrementSpeed(amount);
        }
    }

}
