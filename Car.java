
import java.awt.*;



abstract class Car implements Movable, Loadable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Directions direction;

    private boolean loaded;

    private boolean active;

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
        this.loaded = false;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    public boolean isActive() {
        return active;
    }

    public void toggleActive() {
        this.active = !this.active;
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

    public void setXPosition(double amount){x = amount;}
    public void setYPosition(double amount){y = amount;}

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
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

    protected    void decrementSpeed(double amount){
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
