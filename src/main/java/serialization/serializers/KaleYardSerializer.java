package serialization.serializers;

import entities.containers.KaleYard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class KaleYardSerializer implements BSONSerializer<KaleYard> {
    public void writeToStream(DataOutputStream stream, KaleYard object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public KaleYard readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, KaleYard.class);
    }
}
