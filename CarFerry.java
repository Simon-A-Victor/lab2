import java.awt.*;
import java.util.ArrayList;

public class CarFerry extends Vehicle{
    private boolean rampIsDown;
    private double enginePower;
    private int laneCapacity;
    private ArrayList<Loadable> lane1;

    private ArrayList<Loadable> lane2;

    private ArrayList<Loadable> lane3;


    public CarFerry(Color color, String modelName, double x, double y) {
        super(Color.green, "PaddanXXL", x, y);
        this.rampIsDown = false;
        this.enginePower = 500;
        this.laneCapacity = 15;
        this.lane1 = new ArrayList<Loadable>();
        this.lane2 = new ArrayList<Loadable>();
        this.lane3 = new ArrayList<Loadable>();
        this.setCurrentSpeed(0);
    }
    private double speedFactor(){return 0.5;}

    public int getLaneCapacity(){
        return this.laneCapacity;
    }

    public double getEnginePower(){return this.enginePower;}

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
            LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getLaneCapacity());
            helper.load(other, lane);
        }
    }

    public void unload(Loadable other, ArrayList lane){
        if (this.rampIsDown && lane.getFirst() == other){
            LoaderHelper helper = new LoaderHelper(this.getXPosition(), this.getYPosition(), this.getLaneCapacity());
        }
    }

}
