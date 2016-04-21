package serialization.serializers;

import entities.containers.Stock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 20.04.2016.
 */
public class StockSerializer implements BSONSerializer<Stock> {
    @Override
    public void writeToStream(ByteArrayOutputStream stream, Stock object) throws IOException {
        mapper.writeValue(stream, object);
    }

    @Override
    public Stock readFromStream(ByteArrayInputStream stream) throws IOException {
        return mapper.readValue(stream, Stock.class);
    }
}
