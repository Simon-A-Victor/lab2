
import java.awt.*;



abstract class Car implements Movable {
    public enum Directions{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    private double x;
    private double y;

    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.stopEngine();
    }

    Directions direction  = Directions.NORTH;

    public Directions getDirection(){
        return direction;
    }

    public void setDirection(Directions newDirection){
        direction = newDirection;
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
            case NORTH:
                y += getCurrentSpeed();
                break;
            case WEST:
                x -= getCurrentSpeed();
                break;
            case SOUTH:
                y -= getCurrentSpeed();
                break;
            case EAST:
                x += getCurrentSpeed();
                break;
        }
    }

    @Override
    public void turnLeft() {
        direction = Directions.values()[(direction.ordinal()+3)%4];
    }

    @Override
    public void turnRight() {
        direction = Directions.values()[(direction.ordinal()+1)%4];
    }

}
