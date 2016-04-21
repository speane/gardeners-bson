package serialization.serializers;

import entities.plants.Tree;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class TreeSerializer implements BSONSerializer<Tree> {
    public void writeToStream(ByteArrayOutputStream stream, Tree object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public Tree readFromStream(ByteArrayInputStream stream) throws IOException {
        return mapper.readValue(stream, Tree.class);
    }
}
