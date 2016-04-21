package serialization.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public interface BSONSerializer<T> {
    ObjectMapper mapper = new ObjectMapper(new BsonFactory());

    void writeToStream(ByteArrayOutputStream stream, T object) throws IOException;
    T readFromStream(ByteArrayInputStream stream) throws IOException;
}
