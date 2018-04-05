package astoria.dummymaker.generator.impl.collection.impl.basic;

import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.number.LongGenerator;
import astoria.dummymaker.generator.impl.string.JsonGenerator;

import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * "Default Description"
 *
 * @author GoodforGod
 * @since 24.02.2018
 */
public class MapLongObjectGenerator implements IGenerator<Map<Long, Object>> {

    private final IGenerator<Long> keyGenerator = new LongGenerator();
    private final IGenerator<String> valueGenerator = new JsonGenerator();

    @Override
    public Map<Long, Object> generate() {
        final Map<Long, Object> objectsMap = new HashMap<>();
        final int amount = current().nextInt(1,10);

        for(int i = 0; i < amount; i++)
            objectsMap.put(keyGenerator.generate(), valueGenerator.generate());

        return objectsMap;
    }
}
