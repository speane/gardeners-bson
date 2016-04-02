package serialization.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public interface BSONSerializer<T extends serialization.Serializable> {
    ObjectMapper mapper = new ObjectMapper(new BsonFactory());

    void saveToFile(File file, T object) throws IOException;
    T loadFromFile(File file) throws IOException;
}