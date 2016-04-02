package serialization.serializers;

import entities.plants.Crop;
import entities.plants.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeny Shilov on 02.04.2016.
 */
public class SerializerFactory {
    private static Map<Class, BSONSerializer> serializerMap = new HashMap<Class, BSONSerializer>();
    static {
        serializerMap.put(Tree.class, new TreeSerializer());
        serializerMap.put(Crop.class, new CropSerializer());
    }
    public static BSONSerializer getSerializer(Class type) {
        return serializerMap.get(type);
    }
}
