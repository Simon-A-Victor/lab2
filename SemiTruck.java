import java.awt.*;
import java.util.Stack;

public class SemiTruck extends PlatformVehicle implements Loader{

    private Stack<Loadable> loaded;
    private int maxSize;
    private int capacity;

    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y, 15);
        this.loaded  = new Stack<Loadable>();
        this.maxSize = 5;
        this.capacity = 4;
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

    @Override
    public void load(Loadable other) {
        this.loaded.push(other);
    }

    @Override
    public Loadable unload() {
        Loadable unloaded = this.loaded.pop();
        return unloaded;
    }




}
