package astoria.dummymaker.annotation;

import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.NullGenerator;
import astoria.dummymaker.scan.IAnnotationScanner;

import java.lang.annotation.*;

/**
 * Prime annotations, used to create new annotations of specific generator provided type
 * Used as a marker annotation for other annotations
 *
 * Is used by scanners and populate/produce factories
 *
 * This annotation is a core one to support population factory
 *
 * @see IGenerator
 * @see astoria.dummymaker.scan.IScanner
 * @see IAnnotationScanner
 *
 * @see astoria.dummymaker.factory.IPopulateFactory
 * @see astoria.dummymaker.factory.IProduceFactory
 *
 * @author GoodforGod
 * @since 28.05.2017
 */
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
public @interface PrimeGen {

    /**
     * Contains generator class to be called to generate values on factory
     *
     * @see astoria.dummymaker.factory.IPopulateFactory
     *
     * @return generator
     */
    Class<? extends IGenerator> value() default NullGenerator.class;
}
