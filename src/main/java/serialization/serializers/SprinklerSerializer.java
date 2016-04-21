package serialization.serializers;

import entities.equipment.Sprinkler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class SprinklerSerializer implements BSONSerializer<Sprinkler> {
    public void writeToStream(ByteArrayOutputStream stream, Sprinkler object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Sprinkler readFromStream(ByteArrayInputStream stream) throws IOException {
        return mapper.readValue(stream, Sprinkler.class);
    }
}
