package astoria.dummymaker.scan.impl;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.collection.GenMap;
import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.annotation.special.GenForceExport;
import astoria.dummymaker.annotation.special.GenIgnoreExport;
import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.collection.GenList;
import astoria.dummymaker.annotation.collection.GenMap;
import astoria.dummymaker.annotation.collection.GenSet;
import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.annotation.special.GenForceExport;
import astoria.dummymaker.annotation.special.GenIgnoreExport;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Scanner for special export annotations
 *
 * @see PrimeGen
 * @see GenIgnoreExport
 * @see GenForceExport
 *
 * @see BasicScanner
 *
 * @author GoodforGod
 * @since 03.06.2017
 */
public class ExportScanner extends UniqueScanner {

    /**
     * Check for accepted for export annotations
     *
     * @see GenForceExport
     * @see PrimeGen
     */
    private final Predicate<Annotation> acceptPredicate = (a) -> (a.annotationType().equals(PrimeGen.class)
            || ((a.annotationType().equals(GenForceExport.class))
            && ((GenForceExport) a).value()));

    /**
     * Check for ignorable annotations
     *
     * @see GenIgnoreExport
     */
    private final Predicate<Annotation> ignorePredicate = (a) -> a.annotationType().equals(GenEmbedded.class)
            || a.annotationType().equals(GenList.class)
            || a.annotationType().equals(GenSet.class)
            || a.annotationType().equals(GenMap.class)
            || (a.annotationType().equals(GenIgnoreExport.class) && ((GenIgnoreExport) a).value());

    @Override
    public Map<Field, List<Annotation>> scan(final Class t) {
        final Map<Field, List<Annotation>> classFieldAnnotations = super.scan(t);

        return classFieldAnnotations.entrySet().stream()
                .filter(e -> e.getValue().stream().noneMatch(ignorePredicate))
                .filter(e -> e.getValue().stream().anyMatch(acceptPredicate))
                .peek(e -> e.setValue(e.getValue().stream()
                        .filter(acceptPredicate)
                        .collect(Collectors.toList())))
                .collect(LinkedHashMap<Field, List<Annotation>>::new,
                        (m, e) -> m.put(e.getKey(), e.getValue()),
                        (m, u) -> { }
                );
    }
}
