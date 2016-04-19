package serialization.serializers;

import entities.equipment.Sprinkler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class SprinklerSerializer implements BSONSerializer<Sprinkler> {
    public void writeToStream(DataOutputStream stream, Sprinkler object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Sprinkler readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, Sprinkler.class);
    }
}
