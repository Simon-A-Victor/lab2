import java.util.ArrayList;

public class Volvo240Workshop{

    private LoaderHelper helper;
    private ArrayList<Volvo240> storage;

    public Volvo240Workshop(double x, double y, int capacity){
        helper = new LoaderHelper(x, y, capacity);
        storage = new ArrayList<Volvo240>();
    }

    public void load(Volvo240 other){
        helper.load(other, storage);
    }

    public void unload(Volvo240 other){
        helper.unload(other, storage);
    }
}
