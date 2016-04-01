package entities;

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

    public Farm(Stock stock, Garden garden) {
        this.stock = stock;
        this.garden = garden;
    }
}
