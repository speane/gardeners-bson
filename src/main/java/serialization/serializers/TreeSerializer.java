package serialization.serializers;

import entities.plants.Tree;

import java.io.*;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class TreeSerializer implements BSONSerializer<Tree> {
    public void saveToFile(File file, Tree object) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        mapper.writeValue(dos, object);
    }

    public Tree loadFromFile(File file) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        return mapper.readValue(dis, Tree.class);
    }
}
