import java.awt.*;
import java.lang.reflect.Type;
import java.util.Stack;

public class SemiTruck extends PlatformVehicle implements Loader{

    private Stack<Loadable> loaded;
    private int maxSize;
    private int capacity;
    private Type acceptedtype;

    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y, 15);
        this.loaded  = new Stack<Loadable>();
        this.maxSize = 5;
        this.capacity = 4;
        this.acceptedtype = Car.class;
    }

    public void tiltPlatform() {
        if(this.isStationary()){
            if(this.platformIsUp()){
                this.setPlatformAngle(70);
            } else {
                this.setPlatformAngle(0);
            }
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public int getMaxSize(){return maxSize;}

    @Override
    public int getCapacity(){return capacity;}

    public void placeDown(){
        Loadable unloadVehicle = this.unload();
        if ((unloadVehicle) != null){
           // unloadVehicle.changeLoadedStatus();
           // this.getDirection();
           // unloadVehicle.
        }
    }
    private boolean checkSize(Loadable other){
        return other.getSize() <= this.maxSize;
    }

    private boolean checkType(Loadable other){
        return other.getClass() == acceptedtype;
    }

    private boolean checkCapacity(){
        return this.loaded.size() < this.capacity;
    }

    private boolean checkPosition(Loadable other){
        return (Math.abs(this.getXPosition() - other.getXPosition()) < 5 && Math.abs(this.getYPosition() - other.getYPosition()) < 5);
    }

    private boolean isValid(Loadable other){
        return (this.isStationary() && !this.platformIsUp() && this.checkSize(other) && this.checkType(other) && this.checkCapacity() && this.checkPosition(other));
    }

    @Override
    public void load(Loadable other) {
        if (this.isValid(other)){
            this.loaded.push(other);
        }

    }

    @Override
    public Loadable unload() {
        Loadable unloaded = this.loaded.pop();
        return unloaded;
    }




}
