import java.util.ArrayList;
public class Saab95Workshop{

    private LoaderHelper helper;
    private ArrayList<Saab95> storage;

    public Saab95Workshop(double x, double y, int capacity){
        helper = new LoaderHelper(x, y, capacity);
        storage = new ArrayList<Saab95>();
    }

    public void load(Saab95 other){
        helper.load(other, storage);
    }

    public void unload(Saab95 other){
        helper.unload(other, storage);
    }
}
