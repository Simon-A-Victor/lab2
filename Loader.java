public interface Loader {

    void load(Loadable other);

    void unload();

    int getMaxSize();
}
