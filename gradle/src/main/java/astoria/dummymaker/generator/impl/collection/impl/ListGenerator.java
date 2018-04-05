package astoria.dummymaker.generator.impl.collection.impl;

import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.collection.ICollectionGenerator;

/**
 * Generate array list collection of elements with object type
 *
 * @see BasicCollectionGenerator
 * @see ICollectionGenerator
 *
 * @author GoodforGod
 * @since 06.03.2018
 */
public class ListGenerator extends BasicCollectionGenerator<Object> {

    public ListGenerator() {
        super();
    }

    public ListGenerator(final IGenerator generator) {
        super(generator);
    }
}
