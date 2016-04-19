package entities.equipment;

import serialization.Serializable;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class Tractor implements Serializable {
    private String name;
    private double power;
    private double fuelBalance;

    public Tractor() {
        name = "TR-11";
        power = 14.9;
        fuelBalance = 5.3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getFuelBalance() {
        return fuelBalance;
    }

    public void setFuelBalance(double fuelBalance) {
        this.fuelBalance = fuelBalance;
    }
}
