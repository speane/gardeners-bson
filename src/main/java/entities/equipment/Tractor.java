package entities.equipment;

import serialization.Serializable;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class Tractor implements Serializable {
    public String name;
    public double power;
    public double fuel;
    public Tractor() {
        name = "TR-11";
        power = 14.9;
        fuel = 5.3;
    }
}
