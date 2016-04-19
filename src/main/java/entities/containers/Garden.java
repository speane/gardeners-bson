package entities.containers;

import serialization.Serializable;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Garden implements Serializable {
    private int maxTreesAmount;

    public int getMaxTreesAmount() {
        return maxTreesAmount;
    }

    public void setMaxTreesAmount(int maxTreesAmount) {
        this.maxTreesAmount = maxTreesAmount;
    }
}
