package serialization.serializers;

import entities.equipment.WaterMachine;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class WaterMachineSerializer implements BSONSerializer<WaterMachine> {
    public void saveToFile(DataOutputStream dos, WaterMachine object) throws IOException {
        mapper.writeValue(dos, object);
    }

    public WaterMachine loadFromFile(DataInputStream dis) throws IOException {
        return mapper.readValue(dis, WaterMachine.class);
    }
}
