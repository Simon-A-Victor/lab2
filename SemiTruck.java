import java.awt.*;

public class SemiTruck extends PlatformVehicle{
    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y, 15, 5);
    }

    public void tiltPlatform() {
        if(this.isStationary()){
            if(this.platformIsUp()){
                this.setPlatformAngle(70);
            } else {
                this.setPlatformAngle(0);
            }
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }




}
