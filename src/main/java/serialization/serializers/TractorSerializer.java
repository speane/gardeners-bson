package serialization.serializers;

import entities.equipment.Tractor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class TractorSerializer implements BSONSerializer<Tractor> {
    public void writeToStream(DataOutputStream stream, Tractor object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Tractor readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, Tractor.class);
    }
}
