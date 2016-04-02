package serialization.serializers;

import entities.equipment.Tractor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class TractorSerializer implements BSONSerializer<Tractor> {
    public void saveToFile(DataOutputStream dos, Tractor object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Tractor loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Tractor.class);
    }
}
