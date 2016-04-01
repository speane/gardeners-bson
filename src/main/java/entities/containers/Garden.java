package entities.containers;

import entities.plants.Plant;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Garden {
    private  ArrayList<Plant> plants;

    public Garden() {
        plants = new ArrayList<Plant>();
    }

    public void deletePlant(int index) {
        if (isInRange(index)) {
            plants.remove(index - 1);
        }
    }

    public void setPlantSizeAtIndex(int index, int size) {
        if (isInRange(index)) {
            plants.get(index - 1).setSize(size);
        }
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    private boolean isInRange(int index) {
        return (index >= 0) && (index < plants.size());
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }
}
