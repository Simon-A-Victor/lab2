import java.util.ArrayList;

public class WorkshopHelper {
    private double x;
    private double y;
    private int capacity;

    public WorkshopHelper(double x, double y, int capacity){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    protected boolean checkPosition(Car other){
        return (Math.abs(this.getXPosition() - other.getXPosition()) < 5 && Math.abs(this.getYPosition() - other.getYPosition()) < 5);
    }

    protected boolean checkCapacity(ArrayList storage, int capacity){
        return storage.size() < capacity;
    }

    public double getXPosition(){return this.x;}
    public double getYPosition(){return this.y;}
    public int getCapacity() {
        return capacity;
    }

    public void load(Car other, ArrayList storage){
        if (this.checkPosition(other) && this.checkCapacity(storage, this.getCapacity())){
            storage.add(other);
            other.setCurrentSpeed(0.0);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setUnactive();
        }
    }

    public void unload(Car other, ArrayList storage){
        storage.remove(other);
        other.setXPosition(other.getXPosition()+1);
        other.setActive();
    }



}
