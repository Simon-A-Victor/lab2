public class Workshop implements Loader{
    private double x;
    private double y;
    private int maxSize;
    private int capacity;

    public void Workshop(double x, double y, int maxSize, int capacity){
        this.x = x;
        this.y = y;
        this.maxSize = maxSize;
        this.capacity = capacity;
    }

    @Override
    public void load(Loadable other) {

    }

    @Override
    public void unload() {

    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}
