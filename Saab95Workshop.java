import java.util.ArrayList;
public class Saab95Workshop extends Workshop{

    private ArrayList<Saab95> storage;

    public Saab95Workshop(double x, double y, int capacity){
        super(x, y, capacity);
    }

    public void load(Saab95 other){
        if (this.checkPosition(other) && this.checkCapacity(storage, this.getCapacity())){
            storage.add(other);
        }
    }
    @Override
    public void unload() {
        Saab95 other = storage.getLast();
        storage.removeLast();
        other.setXPosition(other.getXPosition()+1);
    }

    public void unload(Saab95 other){
        storage.remove(other);
        other.setXPosition(other.getXPosition()+1);
    }
}
