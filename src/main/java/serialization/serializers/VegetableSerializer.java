package serialization.serializers;

import entities.plants.Vegetable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class VegetableSerializer implements BSONSerializer<Vegetable> {
    public void writeToStream(ByteArrayOutputStream stream, Vegetable object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Vegetable readFromStream(ByteArrayInputStream stream) throws IOException {
        return mapper.readValue(stream, Vegetable.class);
    }
}
