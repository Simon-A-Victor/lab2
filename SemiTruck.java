import java.awt.*;

public class SemiTruck extends Car {

    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y);
    }

    @Override
    double speedFactor() {
        return 0;
    }
}
