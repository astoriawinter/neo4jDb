package astoria.dummymaker.annotation.collection;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.IGenerator;
import astoria.dummymaker.generator.impl.collection.ICollectionGenerator;
import astoria.dummymaker.generator.impl.collection.impl.ListGenerator;
import astoria.dummymaker.generator.impl.string.IdGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generate list collection
 *
 * @see ICollectionGenerator
 * @see ListGenerator
 *
 * @author GoodforGod
 * @since 05.03.2018
 */
@PrimeGen(ListGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenList {

    Class<? extends IGenerator> value() default IdGenerator.class;

    int min() default 1;

    int max() default 10;

    int fixed() default 0;
}
