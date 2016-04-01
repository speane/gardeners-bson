package entities.plants;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class Plant {
    private final int INITTIAL_SIZE = 1;
    private int size;

    public Plant() {
        size = INITTIAL_SIZE;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
