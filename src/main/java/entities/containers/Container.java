package entities.containers;

import exceptions.IncorrectItemNumberException;

import java.util.ArrayList;

/**
 * Created by Evgeny Shilov on 20.04.2016.
 */
public class Container<T> {
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
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IncorrectItemNumberException();
        }
    }

    public ArrayList<T> getItemList() {
        return items;
    }

    public T get(int index) throws IncorrectItemNumberException {
        try {
            return items.get(index);
        } catch (IndexOutOfBoundsException ex) {
            throw new IncorrectItemNumberException();
        }
    }
}