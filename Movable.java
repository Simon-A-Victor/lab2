public interface Movable {
    public enum Directions{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    void move();
    void turnLeft();
    void turnRight();

    double getXPosition();
    double getYPosition();

    void setXPosition(double amount);
    void setYPosition(double amount);

    void setDirection(Directions direction);

    double getCurrentSpeed();
    void setCurrentSpeed(double speed);
}
