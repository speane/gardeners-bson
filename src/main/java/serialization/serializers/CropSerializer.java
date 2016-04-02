package serialization.serializers;

import entities.plants.Crop;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class CropSerializer implements BSONSerializer<Crop> {
    public void saveToFile(DataOutputStream dos, Crop object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Crop loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Crop.class);
    }
}
