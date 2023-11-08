
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    private double x = 0;
    private double y = 0;

    private String direction = "North";

    public String getDirection(){
        return direction;
    }

    public void setDirection(String newDirection){
        Set<String> validDirection = new HashSet<>(Arrays.asList("North", "East", "South", "West"));
        if (validDirection.contains(newDirection)){
            direction = newDirection;
        }
    }

    public double getXPosition(){
        return x;
    }

    public double getYPosition(){
        return y;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    protected void setTurboOn(){}

    protected void setTurboOff(){}

    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }

    }

    @Override
    public void move() {
        switch (direction){
            case "North":
                y += getCurrentSpeed();
                break;
            case "West":
                x -= getCurrentSpeed();
                break;
            case "South":
                y -= getCurrentSpeed();
                break;
            case "East":
                x += getCurrentSpeed();
                break;
        }
    }

    @Override
    public void turnLeft() {
        switch (direction){
            case "North":
                direction = "West";
                break;
            case "West":
                direction = "South";
                break;
            case "South":
                direction = "East";
                break;
            case "East":
                direction = "North";
                break;
        }
    }

    @Override
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

}
