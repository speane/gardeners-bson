package serialization.serializers;

import entities.containers.Garden;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class GardenSerializer implements BSONSerializer<Garden>{
    public void writeToStream(ByteArrayOutputStream stream, Garden object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Garden readFromStream(ByteArrayInputStream stream) throws IOException {
        return mapper.readValue(stream, Garden.class);
    }
}
