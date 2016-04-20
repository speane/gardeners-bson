package entities.containers;

import exceptions.IncorrectItemNumberException;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 20.04.2016.
 */
public abstract class Container<T> {
    ArrayList<T> items;

    public Container() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(int index) throws IncorrectItemNumberException {
        try {
            items.remove(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IncorrectItemNumberException();
        }
    }

    public void remove(T item) {
        items.remove(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public T get(int index) throws IncorrectItemNumberException {
        try {
            return items.get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IncorrectItemNumberException();
        }
    }

    public String toString() {
        String result = "";
        for (T item : items) {
            result += item;
        }
        return result;
    }
}
