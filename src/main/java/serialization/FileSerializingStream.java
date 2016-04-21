package serialization;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Evgeny Shilov on 21.04.2016.
 */
public class FileSerializingStream {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public FileSerializingStream(File file) throws FileNotFoundException {
        inputStream = new DataInputStream(new FileInputStream(file));
        outputStream = new DataOutputStream(new FileOutputStream(file));
    }

    public <T> void write(T object) throws IOException {
        byte[] objectBytes = BSONSerializer.serialze(object);
        outputStream.write(objectBytes);
    }

    public <T> T read(Class<T> type) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int documentLength = inputStream.readInt();
        byteArrayOutputStream.write(ByteBuffer.allocate(documentLength).order(ByteOrder.LITTLE_ENDIAN).array());

        for (int i = 0; i < documentLength - 4; i++) {
            byteArrayOutputStream.write(inputStream.read());
        }

        return BSONSerializer.deserialize(byteArrayOutputStream.toByteArray(), type);
    }
}
