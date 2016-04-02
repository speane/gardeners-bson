package serialization.serializers;

import entities.plants.Crop;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class CropSerializer implements BSONSerializer<Crop> {
    public void saveToFile(File file, Crop object) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        mapper.writeValue(dos, object);
    }

    public Crop loadFromFile(File file) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        return mapper.readValue(dis, Crop.class);
    }
}
