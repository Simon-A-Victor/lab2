import java.lang.reflect.Array;

public interface Loader {

    void load(Loadable other);

    void unload();

    int getMaxSize();

    int getCapacity();
}
