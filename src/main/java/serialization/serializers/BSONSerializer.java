package serialization.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public interface BSONSerializer<T extends serialization.Serializable> {
    ObjectMapper mapper = new ObjectMapper(new BsonFactory());

    void writeToStream(DataOutputStream stream, T object) throws IOException;
    T readFromStream(DataInputStream stream) throws IOException;
}
