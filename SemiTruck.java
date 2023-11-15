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

    public int getMaxSize(){return maxSize;}

    @Override
    public int getCapacity(){return capacity;}

    private boolean checkSize(Loadable other){
        return other.getSize() <= this.getMaxSize();
    }

    private boolean checkType(Loadable other){
        return other.getClass() == acceptedtype;
    }

    private boolean checkCapacity(){
        return this.loaded.size() < this.getCapacity();
    }

    private boolean checkPosition(Loadable other){
        return (Math.abs(this.getXPosition() - other.getXPosition()) < 5 && Math.abs(this.getYPosition() - other.getYPosition()) < 5);
    }

    private boolean isValid(Loadable other){
        return (this.isStationary() && !this.platformIsUp() && this.checkSize(other) && this.checkType(other) && this.checkCapacity() && this.checkPosition(other));
    }

    public boolean isLoaded(){
        return !(this.loaded.isEmpty());
    }

    public boolean platformIsUp(){
        return (this.getPlatformAngle() == 0);
    }

    public boolean validDistance(Loadable other){
        double XDiff = Math.abs(this.getXPosition() - other.getXPosition());
        double YDiff = Math.abs(this.getYPosition() - other.getYPosition());
        double totDiff = Math.sqrt(XDiff*XDiff + YDiff*YDiff);
        return (totDiff < 4);
    }


    public void load(Car other) {
        if (this.isValid(other) && !this.platformIsUp()){
            other.setUnactive();
            this.loaded.push(other);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setCurrentSpeed(this.getCurrentSpeed());
            other.setDirection(this.getDirection());
        }
    }
    @Override
    public void unload() {
        if (this.isLoaded() && !this.platformIsUp()){
            Loadable unloaded = this.loaded.pop();
            double currentPosition = this.getXPosition();
            unloaded.setXPosition(currentPosition += 1);
            unloaded.setActive();
        }
    }

    public void alignStoredVehicles(){
        for (Loadable loadable : loaded) {
            loadable.setDirection(this.getDirection());
            loadable.setXPosition(this.getXPosition());
            loadable.setYPosition(this.getYPosition());
        }

    }

    @Override
    public void turnLeft() {
        this.setDirection(Directions.values()[(this.getDirection().ordinal()+3)%4]);
        this.alignStoredVehicles();

    }
    @Override
    public void turnRight() {
        this.setDirection(Directions.values()[(this.getDirection().ordinal()+1)%4]);
        this.alignStoredVehicles();
    }

    @Override
    public void move() {
        switch (this.getDirection()){
            case NORTH:
                this.setYPosition(this.getYPosition() + this.getCurrentSpeed());
                break;
            case WEST:
                this.setXPosition(this.getXPosition() - this.getCurrentSpeed());
                break;
            case SOUTH:
                this.setYPosition(this.getYPosition() - this.getCurrentSpeed());
                break;
            case EAST:
                this.setXPosition(this.getXPosition() + this.getCurrentSpeed());
                break;
        }
        this.alignStoredVehicles();
    }


}
