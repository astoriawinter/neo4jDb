package astoria.dummymaker.scan;

import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.scan.impl.BasicScanner;
import astoria.dummymaker.scan.impl.UniqueScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Field scanner used to scan for field annotations
 * Mostly used by factories to retrieve info for them
 *
 * @see BasicScanner
 * @see UniqueScanner
 * @see IPopulateFactory
 *
 * @author GoodforGod
 * @since 30.05.2017
 */
public interface IAnnotationScanner extends IScanner<Field, List<Annotation>> {

    /**
     * Scan class for field annotations
     *
     * @param t class to scan
     * @return Returns Map with field and annotations associated with that field
     */
    @Override
    Map<Field, List<Annotation>> scan(final Class t);
}
