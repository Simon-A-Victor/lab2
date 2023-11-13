
import java.awt.*;



abstract class Car implements Movable, Loadable {
    public enum Directions{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Directions direction;

    private int size;

    private double x;
    private double y;

    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.size = size;
        this.stopEngine();
        this.direction  = Directions.NORTH;
    }



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

    public boolean isStationary(){
        double speed = getCurrentSpeed();
        return speed == 0;
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

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
        this.setDirection(Directions.values()[(direction.ordinal()+3)%4]);
    }

    @Override
    public void turnRight() {
        this.setDirection(Directions.values()[(direction.ordinal()+1)%4]);
    }

    @Override
    public int getSize(){ return size;}
}
