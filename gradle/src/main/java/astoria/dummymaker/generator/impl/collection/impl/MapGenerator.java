package astoria.dummymaker.generator.impl.collection.impl;

import astoria.dummymaker.generator.IGenerator;

/**
 * Generate map of elements with key,value of object type
 *
 * @see BasicMapGenerator
 * @see astoria.dummymaker.generator.impl.collection.IMapGenerator
 *
 * @author GoodforGod
 * @since 06.03.2018
 */
public class MapGenerator extends BasicMapGenerator<Object, Object> {

    public MapGenerator() {
        super();
    }

    public MapGenerator(final IGenerator keyGenerator,
                        final IGenerator valueGenerator) {
        super(keyGenerator, valueGenerator);
    }
}
