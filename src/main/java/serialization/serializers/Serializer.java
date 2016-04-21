package serialization.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.undercouch.bson4jackson.BsonFactory;
import entities.equipment.Sprinkler;
import entities.equipment.Tractor;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Evgeny Shilov on 20.04.2016.
 */
public class Serializer {
    public static <T> T deserialize(ByteArrayInputStream inputStream, Class<T> type) throws IOException {
        BSONSerializer serializer = SerializerFactory.getSerializer(type);
        return (T) serializer.readFromStream(inputStream);
    }

    public static void serialize(ByteArrayOutputStream outputStream, Object o) throws IOException {
        BSONSerializer serializer = SerializerFactory.getSerializer(o.getClass());
        serializer.writeToStream(outputStream, o);
    }

    public static void testSerialize() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper(new BsonFactory());
        try {
            //File file = new File("resf.txt");
            //DataInputStream dis = new DataInputStream(new FileInputStream(file));

            mapper.writeValue(baos, new Tractor());

            mapper.writeValue(baos, new Sprinkler());

            //DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            //mapper.readValue(dataInputStream, );

            byte[] bytes = baos.toByteArray();

            int length = java.nio.ByteBuffer.wrap(bytes, 0, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

            Tractor tractor = mapper.readValue(bytes, 0, length, Tractor.class);

            //bais = new ByteArrayInputStream(baos2.toByteArray());
            int sprinklerLength = ByteBuffer.wrap(bytes, length, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
            Sprinkler sprinkler = mapper.readValue(bytes, length, sprinklerLength, Sprinkler.class);


            System.out.println(tractor.getName());
            System.out.println(sprinkler.getName());
            //Tractor tractor = mapper.readValue(dataInputStream, Tractor.class);
            //System.out.println(tractor.getName());
            /*Sprinkler sprinkler = mapper.readValue(dataInputStream, Sprinkler.class);
            System.out.println(sprinkler.getName());*/


            //baos.writeTo(new DataOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void testDeserialize() {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream(new File("res.txt")));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int tempByte;
            while ((tempByte = inputStream.read()) != -1) {
                byteArrayOutputStream.write(tempByte);
            }

            byteArrayOutputStream.writeTo(System.out);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

            Tractor tractor = deserialize(byteArrayInputStream, Tractor.class);
            System.out.println("\n" + tractor.getName());

            Sprinkler sprinkler = deserialize(byteArrayInputStream, Sprinkler.class);
            System.out.println(sprinkler.getName());

            //ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
