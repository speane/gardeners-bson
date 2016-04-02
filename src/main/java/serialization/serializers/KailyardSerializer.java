package serialization.serializers;

import entities.containers.Kailyard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class KailyardSerializer implements BSONSerializer<Kailyard> {
    public void saveToFile(DataOutputStream dos, Kailyard object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Kailyard loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Kailyard.class);
    }
}
