import java.util.ArrayList;

public class GeneralWorkshop{
    private int maxSize;

    public WorkshopHelper helper;
    private ArrayList<Car> storage;

    public GeneralWorkshop(double x, double y, int capacity, int maxSize){
        helper = new WorkshopHelper(x, y, capacity);
        storage = new ArrayList<Car>();
        this.maxSize = maxSize;
    }

    private boolean checkSize(Car other){
        return other.getSize() <= this.maxSize;
    }

    public void load(Car other) {
        if (this.checkSize(other)){
            helper.load(other, storage);
        }
    }

    public void unload(Car other){
        helper.unload(other, storage);
    }
}
