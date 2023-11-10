import java.awt.*;

public class Scania extends Car {

    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y);
    }

    public double platformAngle = 0;

    public void tiltPlatform(int degrees) {

        platformAngle += degrees;

        if (platformAngle > 70) {
            platformAngle = 70;
        } else if (platformAngle < 0) {
            platformAngle = 0;
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }

}
