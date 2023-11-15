import java.awt.*;
import java.lang.reflect.Type;
import java.util.Stack;

public class SemiTruck extends PlatformVehicle{

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

    public int getMaxSize(){return maxSize;}

    public int getCapacity(){return capacity;}

    private boolean checkSize(Loadable other){
        return other.getSize() <= this.getMaxSize();
    }

    public boolean isLoaded(){
        return !(this.loaded.isEmpty());
    }

    public boolean platformIsUp(){
        return (this.getPlatformAngle() == 0);
    }

    public void load(Car other) {
        if (other.getSize() <= this.getMaxSize() && !this.platformIsUp()){
            LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getCapacity());
            helper.load(other, loaded);
            other.setDirection(this.getDirection());
        }
    }

    public void unload(Car other) {
        if (loaded.getLast() == other && !this.platformIsUp()){
            LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getCapacity());
            helper.unload(other, loaded);
        }
    }

    @Override
    public void turnLeft() {
        this.setDirection(Directions.values()[(this.getDirection().ordinal()+3)%4]);
        LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getDirection());
        helper.alignLoadables(loaded);
    }
    @Override
    public void turnRight() {
        this.setDirection(Directions.values()[(this.getDirection().ordinal()+1)%4]);
        LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getDirection());
        helper.alignLoadables(loaded);
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
        LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getDirection());
        helper.alignLoadables(loaded);
    }


}
