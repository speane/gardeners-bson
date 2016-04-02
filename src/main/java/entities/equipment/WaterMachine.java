package entities.equipment;

import serialization.Serializable;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class WaterMachine implements Serializable {
    public String name;
    public double capacity;
    public double waterRemain;
    public double pressure;
    public WaterMachine() {
        name = "FX-4";
        capacity = 12.4;
        waterRemain = 1.5;
        pressure = 2;
    }
}
