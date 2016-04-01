package entities.containers;

import entities.plants.Plant;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Garden {
    private ArrayList<Plant> plants;

    public Garden() {
        plants = new ArrayList<Plant>();
    }

    public void delete(int index) {
        if (isInRange(index)) {
            plants.remove(index);
        }
    }

    public void setPlantSizeAtIndex(int index, int size) {
        if (isInRange(index)) {
            plants.get(index).setSize(size);
        }
    }

    private boolean isInRange(int index) {
        return (index >= 0) && (index < plants.size());
    }
}
