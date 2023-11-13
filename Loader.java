public interface Loader {

    void load(Loadable other);

    Loadable unload();

    int getMaxSize();

    int getCapacity();

    void placeDown();
}
