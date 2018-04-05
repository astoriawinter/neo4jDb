package astoria.dummymaker.factory.impl;

import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.collection.ICollectionGenerator;
import astoria.dummymaker.generator.impl.collection.impl.SetGenerator;
import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.collection.ICollectionGenerator;
import astoria.dummymaker.generator.impl.collection.impl.SetGenerator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Generates set object filled with annotation generator specified type values
 *
 * @see GenSet
 * @see astoria.dummymaker.factory.IGenerateFactory
 * @see BasicGenerateFactory
 *
 * @author GoodforGod
 * @since 08.03.2018
 */
public class SetGenerateFactory extends BasicGenerateFactory<ICollectionGenerator<?>> {

    public SetGenerateFactory() {
        super(GenSet.class);
    }

    /**
     * Method to produce fields value
     *
     * @see GenSet
     *
     * @param field field to populate
     * @param annotation fields annotations
     */
    @Override
    public Object generate(final Field field,
                           final Annotation annotation) {
        return generate(field, annotation, new SetGenerator());
    }

    /**
     * Method to produce fields value
     *
     * @see GenSet
     *
     * @param field field to populate
     * @param annotation fields annotations
     */
    @Override
    public Object generate(final Field field,
                           final Annotation annotation,
                           final ICollectionGenerator<?> generator) {
        try {
            if(field == null || annotation == null || !field.getType().isAssignableFrom(Set.class))
                return null;

            if(generator == null)
                return generate(field, annotation);

            int fixed = ((GenSet) annotation).fixed();
            int min = ((GenSet) annotation).min();
            int max = ((GenSet) annotation).max();
            if (fixed > 0) {
                min = max = fixed;
            }

            final IGenerator valueGenerator = ((GenSet) annotation).value().newInstance();
            final Type fieldType = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

            return generator.generate(valueGenerator, ((Class<?>) fieldType), min, max);
        } catch (InstantiationException | IllegalAccessException e) {
            logger.warning(e.getMessage());
            return null;
        }
    }
}
