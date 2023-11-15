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

    }

    @Override
    public void unload() {

    }
}
