import java.util.ArrayList;

public class GeneralWorkshop extends Workshop{
    private int maxSize;
    private ArrayList<Car> storage;

    public GeneralWorkshop(double x, double y, int capacity, int maxSize){
        super(x, y, capacity);
        this.maxSize = maxSize;
    }

    @Override
    public void load(Loadable other) {
        if (other instanceof Car && this.checkPosition(other)){
            storage.add((Car) other);
            other.setCurrentSpeed(0.0);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setUnactive();
        }
    }

    @Override
    public void unload() {

    }
}
