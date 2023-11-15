abstract class Workshop implements Loader{
    private double x;
    private double y;
    private int capacity;

    public Workshop(double x, double y, int capacity){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    public double getXPosition(){return this.x;}
    public double getYPosition(){return this.y;}

    @Override
    public int getCapacity() {
        return capacity;
    }
}
