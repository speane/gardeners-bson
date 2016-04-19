package serialization.serializers;

import entities.equipment.WaterMachine;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class WaterMachineSerializer implements BSONSerializer<WaterMachine> {
    public void writeToStream(DataOutputStream stream, WaterMachine object) throws IOException {
        mapper.writeValue(stream, object);
    }

    public WaterMachine readFromStream(DataInputStream stream) throws IOException {
        return mapper.readValue(stream, WaterMachine.class);
    }
}
