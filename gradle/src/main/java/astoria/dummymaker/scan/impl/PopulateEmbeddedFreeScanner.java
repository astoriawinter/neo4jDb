package astoria.dummymaker.scan.impl;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.collection.GenMap;
import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.generator.impl.EmbeddedGenerator;
import astoria.dummymaker.scan.container.PopulateContainer;
import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.collection.GenList;
import astoria.dummymaker.annotation.collection.GenMap;
import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.generator.impl.EmbeddedGenerator;
import astoria.dummymaker.scan.container.PopulateContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Scanner used by populate factory
 *
 * Scan for prime gen annotation and its child annotation
 * EXCLUDE EMBEDDED ANNOTATED FIELDS
 *
 * @see PrimeGen
 * @see GenEmbedded
 *
 * @see BasicScanner
 * @see IPopulateFactory
 *
 * @author GoodforGod
 * @since 10.03.2018
 */
public class PopulateEmbeddedFreeScanner extends PopulateScanner {

    /**
     * Predicate to check for embedded marker annotation
     * Also check for GenCollection annotations with EmbeddedGenerator
     *
     * @see GenEmbedded
     */
    private final Predicate<Annotation> isEmbedded = (a) -> a.annotationType().equals(GenEmbedded.class)
            || a.annotationType().equals(GenList.class) && ((GenList) a).value().equals(EmbeddedGenerator.class)
            || a.annotationType().equals(GenSet.class) && ((GenSet) a).value().equals(EmbeddedGenerator.class)
            || a.annotationType().equals(GenMap.class)
                && (((GenMap) a).key().equals(EmbeddedGenerator.class) || ((GenMap) a).value().equals(EmbeddedGenerator.class));

    @Override
    public Map<Field, PopulateContainer> scan(final Class t) {
        return super.scan(t).entrySet()
                .stream()
                .filter(e -> !isEmbedded.test(e.getValue().getGen()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
