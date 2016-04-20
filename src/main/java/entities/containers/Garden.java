package entities.containers;

import entities.plants.Tree;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Garden extends Container<Tree> {
    private int maxTreesAmount;

    public int getMaxTreesAmount() {
        return maxTreesAmount;
    }

    public void setMaxTreesAmount(int maxTreesAmount) {
        this.maxTreesAmount = maxTreesAmount;
    }
}
