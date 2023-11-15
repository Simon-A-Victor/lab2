import java.util.ArrayList;

public class Volvo240Workshop extends Workshop{
    private ArrayList<Volvo240> storage;

    public Volvo240Workshop(double x, double y, int capacity){
        super(x, y, capacity);
    }

    public void load(Volvo240 other){
        if (this.checkPosition(other) && this.checkCapacity(storage, this.getCapacity())){
            storage.add(other);
        }
    }
    @Override
    public void unload() {
        Volvo240 other = storage.getLast();
        storage.removeLast();
        other.setXPosition(other.getXPosition()+1);
    }

    public void unload(Volvo240 other){
        storage.remove(other);
        other.setXPosition(other.getXPosition()+1);
    }
}
