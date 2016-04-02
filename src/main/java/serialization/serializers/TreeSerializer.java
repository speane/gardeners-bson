package serialization.serializers;

import entities.plants.Tree;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class TreeSerializer implements BSONSerializer<Tree> {
    public void saveToFile(DataOutputStream dos, Tree object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public Tree loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, Tree.class);
    }
}
