import java.util.ArrayList;
public class Saab95Workshop{

    private WorkshopHelper helper;
    private ArrayList<Saab95> storage;

    public Saab95Workshop(double x, double y, int capacity){
        helper = new WorkshopHelper(x, y, capacity);
    }

    public void load(Saab95 other){
        helper.load(other, storage);
    }

    public void unload(Saab95 other){
        helper.load(other, storage);
    }
}
