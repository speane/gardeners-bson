package entities.plants;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Tree {
    private String name;
    private int height;
    private int age;

    public Tree(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public Tree() {
        this.name = "Unnamed";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
