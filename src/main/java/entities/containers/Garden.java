package entities.containers;

import entities.plants.Tree;
import serialization.Serializable;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Garden implements Serializable {
    private ArrayList<Tree> trees;

    public Garden() {
        trees = new ArrayList<Tree>();
    }

    public void deletePlant(int index) {
        if (isInRange(index)) {
            trees.remove(index - 1);
        }
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    private boolean isInRange(int index) {
        return (index > 0) && (index <= trees.size());
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }
}
