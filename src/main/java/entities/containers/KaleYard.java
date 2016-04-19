package entities.containers;

import entities.plants.Vegetable;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class KaleYard extends Container<Vegetable> {
    private int area;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
