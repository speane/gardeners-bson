package serialization.serializers;

import entities.containers.Garden;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class GardenSerializer implements BSONSerializer<Garden>{
    public void writeToStream(DataOutputStream stream, Garden object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Garden readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, Garden.class);
    }
}
