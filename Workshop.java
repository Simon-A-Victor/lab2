abstract class Workshop implements Loader{
    private double x;
    private double y;
    private int capacity;

    public Workshop(double x, double y, int capacity){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    protected boolean checkPosition(Loadable other){
        return (Math.abs(this.getXPosition() - other.getXPosition()) < 5 && Math.abs(this.getYPosition() - other.getYPosition()) < 5);
    }

    public double getXPosition(){return this.x;}
    public double getYPosition(){return this.y;}

    @Override
    public int getCapacity() {
        return capacity;
    }
}
