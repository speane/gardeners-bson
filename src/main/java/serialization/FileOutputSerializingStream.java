package serialization;

import java.io.*;

/**
 * Created by Evgeny Shilov on 21.04.2016.
 */
public class FileOutputSerializingStream {

    private DataOutputStream outputStream;

    public FileOutputSerializingStream(File file) throws FileNotFoundException {
        outputStream = new DataOutputStream(new FileOutputStream(file));
    }

    public <T> void write(T object) throws IOException {
        byte[] objectBytes = BSONSerializer.serialze(object);
        outputStream.write(objectBytes);
    }

    public void close() throws IOException {
        outputStream.close();
    }
}
