package serialization.serializers;

import entities.plants.Crop;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class CropSerializer implements BSONSerializer<Crop> {
    public void writeToStream(DataOutputStream stream, Crop object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Crop readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, Crop.class);
    }
}
