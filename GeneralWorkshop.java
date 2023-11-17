import java.util.ArrayList;

public class GeneralWorkshop{
    private int maxSize;

    public LoaderHelper helper;
    private ArrayList<Car> storage;

    public GeneralWorkshop(double x, double y, int capacity, int maxSize){
        helper = new LoaderHelper(x, y, capacity);
        storage = new ArrayList<Car>();
        this.maxSize = maxSize;
    }

    private boolean checkSize(Vehicle other){
        return other.getSize() <= this.maxSize;
    }

    public void load(Vehicle other) {
        if (this.checkSize(other)){
            helper.load(other, storage);
        }
    }

    public void unload(Vehicle other){
        helper.unload(other, storage);
    }
}
