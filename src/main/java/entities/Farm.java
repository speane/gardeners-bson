package entities;

import entities.containers.Garden;
import entities.containers.Stock;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Farm {
    public Stock stock;
    public Garden garden;

    public Farm() {
        this.stock = new Stock();
        this.garden = new Garden();
    }
}
