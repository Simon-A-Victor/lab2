import java.awt.*;

public class Vehicle implements Movable {
    private double currentSpeed;
    private Color color;
    private String modelName;
    private Directions direction;
    private double x;
    private double y;

    public Vehicle(Color color, String modelName, double x, double y){
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
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
    public double getXPosition() {
        return this.x;
    }

    @Override
    public double getYPosition() {
        return this.y;
    }

    @Override
    public void setXPosition(double amount) {
        this.x = amount;
    }

    @Override
    public void setYPosition(double amount) {
        this.y = amount;
    }

    @Override
    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    @Override
    public Directions getDirection() {
        return this.direction;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }
}
