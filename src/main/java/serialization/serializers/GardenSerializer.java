package serialization.serializers;

import entities.containers.Garden;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class GardenSerializer implements BSONSerializer<Garden>{
    public void saveToFile(DataOutputStream dos, Garden object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Garden loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Garden.class);
    }
}
