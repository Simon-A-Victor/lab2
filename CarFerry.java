import java.awt.*;
import java.util.ArrayList;

public class CarFerry extends Vehicle{
    private boolean rampIsDown;
    private double enginePower;
    private int maxSize;
    private int lanes;
    private int laneCapacity;
    private ArrayList<ArrayList<Loadable>> laneList;

    private Directions direction;


    public CarFerry(Color color, String modelName, double x, double y) {
        super(Color.green, "PaddanXXL", x, y, 200);
        this.rampIsDown = false;
        this.enginePower = 50;
        this.maxSize = 15;
        this.lanes = 3;
        this.laneCapacity = 15;
        this.direction = Directions.NORTH;
        this.laneList = new ArrayList<ArrayList<Loadable>>();
        for (int i = 0; i < this.lanes; i++){
            laneList.add(new ArrayList<Loadable>());
        }
        this.setCurrentSpeed(0);
    }
    private double speedFactor(){return 0.5;}

    public int getLaneCapacity(){
        return this.laneCapacity;
    }

    public double getEnginePower(){return this.enginePower;}

    public int getMaxSize(){
        return this.maxSize;
    }

    public boolean checkSize(Loadable other){return other.getSize() <= this.getMaxSize();}

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            this.incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }

    public void load(Loadable other, ArrayList lane){
        if (this.rampIsDown){
            if (this.checkSize(other)){
                LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getLaneCapacity());
                helper.load(other, lane);
            }
        }
    }

    public void unload(Loadable other, ArrayList lane){
        if (this.rampIsDown && lane.getFirst() == other){
            LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getLaneCapacity());
            helper.unload(other, lane);
        }
    }

    private void alignContents(){
        LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getDirection());
        for (ArrayList<Loadable> lane : laneList){
            helper.alignLoadables(lane);
        }
    }

    @Override
    public void turnLeft() {
        if (isActive()){
            this.setDirection(Directions.values()[(this.getDirection().ordinal()+3)%4]);
            this.alignContents();
        }
    }
    @Override
    public void turnRight() {
        if (isActive()){
            this.setDirection(Directions.values()[(this.getDirection().ordinal()+1)%4]);
            this.alignContents();
        }
    }

    @Override
    public void move() {
        if (isActive()){
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
            this.alignContents();
        }
    }
}
