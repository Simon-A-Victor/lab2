import java.util.ArrayList;

public class GeneralWorkshop extends Workshop{
    private int maxSize;
    private ArrayList<Car> storage;

    public GeneralWorkshop(double x, double y, int capacity, int maxSize){
        super(x, y, capacity);
        this.maxSize = maxSize;
    }

    private boolean checkSize(Car other){
        return other.getSize() <= this.maxSize;
    }

    public void load(Car other) {
        if (this.checkPosition(other) && this.checkSize(other) && this.checkCapacity(storage, this.getCapacity())){
            storage.add(other);
            other.setCurrentSpeed(0.0);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setUnactive();
        }
    }

    @Override
    public void unload() {
        Car other = storage.getLast();
        storage.removeLast();
        other.setXPosition(other.getXPosition()+1);
    }

    public void unload(Car other){
        storage.remove(other);
        other.setXPosition(other.getXPosition()+1);
    }
}
