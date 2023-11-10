import java.awt.*;

public class SemiTruck extends platformVehicle {

    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y);
    }

    public void tiltPlatform() {
        if(this.isStationary()){
            if(this.platformIsDown()){
                this.setPlatformAngle(0);
            } else {
                this.setPlatformAngle(70);
            }
        }
    }

    @Override
    double speedFactor() {
        return 1;
    }
}
