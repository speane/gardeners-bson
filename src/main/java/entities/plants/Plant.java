package entities.plants;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public abstract class Plant {
    private final int INITTIAL_SIZE = 1;
    protected int size;
    protected String name;

    public Plant() {
        size = INITTIAL_SIZE;
    }

    public Plant(int size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
