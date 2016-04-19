package entities.equipment;

import serialization.Serializable;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class Sprinkler implements Serializable {
    private String name;
    private double capacity;
    private double waterBalance;
    private double pressure;

    public Sprinkler() {
        name = "FX-4";
        capacity = 12.4;
        waterBalance = 1.5;
        pressure = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(double waterBalance) {
        this.waterBalance = waterBalance;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
