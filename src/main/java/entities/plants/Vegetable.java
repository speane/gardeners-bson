package entities.plants;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class Vegetable {
    private String name;
    private int fertilizers;
    private int moisture;
    private int aging;

    public Vegetable(String name, int fertilizers, int moisture, int aging) {
        this.name = name;
        this.fertilizers = fertilizers;
        this.moisture = moisture;
        this.aging = aging;
    }

    public Vegetable() {
        this.name = "Unnamed";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(int fertilizers) {
        this.fertilizers = fertilizers;
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }

    public int getAging() {
        return aging;
    }

    public void setAging(int aging) {
        this.aging = aging;
    }

    public String toString() {
        return "[" + name + "(" + fertilizers + ", " + moisture + "%, " + aging + ")]";
    }
}
