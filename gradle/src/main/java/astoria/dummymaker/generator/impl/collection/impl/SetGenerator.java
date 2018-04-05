package astoria.dummymaker.generator.impl.collection.impl;

import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.collection.ICollectionGenerator;

import java.util.Collection;
import java.util.HashSet;

/**
 * Generate hash set collection of elements with object type
 *
 * @see BasicCollectionGenerator
 * @see ICollectionGenerator
 *
 * @author GoodforGod
 * @since 06.03.2018
 */
public class SetGenerator extends BasicCollectionGenerator<Object> {

    public SetGenerator() {
        super();
    }

    public SetGenerator(final IGenerator generator) {
        super(generator);
    }

    @Override
    public Collection<Object> generate() {
        return new HashSet<>(super.generate());
    }

    @Override
    public Collection<Object> generate(final IGenerator generator,
                                       final Class<?> fieldType,
                                       final int min,
                                       final int max) {
        return new HashSet<>(super.generate(generator, fieldType, min, max));
    }
}
