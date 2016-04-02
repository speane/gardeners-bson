package serialization.serializers;

import entities.plants.Vegetable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class VegetableSerializer implements BSONSerializer<Vegetable> {
    public void saveToFile(DataOutputStream dos, Vegetable object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Vegetable loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Vegetable.class);
    }
}
