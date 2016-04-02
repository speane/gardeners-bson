package serialization.serializers;

import entities.containers.Garden;
import entities.containers.Kailyard;
import entities.equipment.Tractor;
import entities.equipment.WaterMachine;
import entities.plants.Tree;
import entities.plants.Vegetable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class SerializerFactory {
    private static Map<Class, BSONSerializer> serializerMap = new HashMap<Class, BSONSerializer>();
    static {
        serializerMap.put(Tree.class, new TreeSerializer());
        serializerMap.put(Kailyard.class, new KailyardSerializer());
        serializerMap.put(Garden.class, new GardenSerializer());
        serializerMap.put(Tractor.class, new TractorSerializer());
        serializerMap.put(WaterMachine.class, new WaterMachineSerializer());
        serializerMap.put(Vegetable.class, new VegetableSerializer());
    }
    public static BSONSerializer getSerializer(Class type) {
        return serializerMap.get(type);
    }
}
