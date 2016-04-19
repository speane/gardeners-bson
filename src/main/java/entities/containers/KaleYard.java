package entities.containers;

import entities.plants.Vegetable;
import serialization.Serializable;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class KaleYard implements Serializable {
    private ArrayList<Vegetable> vegetables;

    public KaleYard() {
        vegetables = new ArrayList<Vegetable>();
    }

    public void deleteVegetable(int index) {
        if (isInRange(index)) {
            vegetables.remove(index - 1);
        }
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    private boolean isInRange(int index) {
        return (index > 0) && (index <= vegetables.size());
    }

    public ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }
}
