package entities.containers;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Stock {
    private int capacity;
    private int occupancy;

    public Stock(int capacity, int occupancy) {
        this.capacity = capacity;
        this.occupancy = occupancy;
    }

    public Stock() {

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}
