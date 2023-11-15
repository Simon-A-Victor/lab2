import java.util.ArrayList;
import java.util.Collection;

public class LoaderHelper {
    private double x;
    private double y;
    private int capacity;

    public LoaderHelper(double x, double y, int capacity){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    private boolean validDistance(Loadable other){
        double XDiff = Math.abs(this.getXPosition() - other.getXPosition());
        double YDiff = Math.abs(this.getYPosition() - other.getYPosition());
        double totDiff = Math.sqrt(XDiff*XDiff + YDiff*YDiff);
        return (totDiff < 4);
    }

    private boolean checkCapacity(Collection storage, int capacity){
        return storage.size() < capacity;
    }

    private double getXPosition(){return this.x;}
    private double getYPosition(){return this.y;}
    private int getCapacity() {
        return capacity;
    }

    public void load(Loadable other, Collection storage){
        if (this.validDistance(other) && this.checkCapacity(storage, this.getCapacity()) && !storage.contains(other)){
            storage.add(other);
            other.setCurrentSpeed(0.0);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setUnactive();
        }
    }

    public void unload(Loadable other, Collection storage){
        if (storage.contains(other)){
            storage.remove(other);
            other.setXPosition(other.getXPosition()+1);
            other.setActive();
        }
    }



}
