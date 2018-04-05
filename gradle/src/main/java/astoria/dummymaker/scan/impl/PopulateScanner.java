package astoria.dummymaker.scan.impl;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.scan.container.PopulateContainer;
import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.scan.IPopulateScanner;
import astoria.dummymaker.scan.container.PopulateContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Scanner used by populate factory
 *
 * Scan for prime gen annotation and its child annotation
 * Scan also for GenEmbedded annotations to populate embedded fields
 *
 * @see PrimeGen
 * @see GenEmbedded
 *
 * @see BasicScanner
 * @see IPopulateFactory
 *
 * @author GoodforGod
 * @since 29.05.2017
 */
public class PopulateScanner implements IPopulateScanner {

    /**
     * Predicate to check for core prime marker annotation
     *
     * @see PrimeGen
     */
    private final Predicate<Annotation> isPrime = (a) -> a.annotationType().equals(PrimeGen.class);

    /**
     * Scan for prime gen annotation and its child annotation*
     *
     * @param t class to scan
     * @return populate field map, where
     * KEY is field that has populate annotations
     * VALUE are two annotations:
     * - 0 is primeGen annotation
     * - 1 is child primeGen annotation
     */
    @Override
    public Map<Field, PopulateContainer> scan(final Class t) {
        final Map<Field, PopulateContainer> populateAnnotationMap = new HashMap<>();

        for(final Field field : t.getDeclaredFields()) {
            for(Annotation annotation : field.getDeclaredAnnotations()) {
                for(Annotation inlined : annotation.annotationType().getDeclaredAnnotations()) {
                    if(isPrime.test(inlined)) {
                        populateAnnotationMap.put(field, new PopulateContainer(inlined, annotation));
                    }
                }
            }
        }

        return populateAnnotationMap;
    }
}
