package astoria.dummymaker.annotation.time;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.time.impl.LocalDateGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see LocalDateGenerator
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
@PrimeGen(LocalDateGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenLocalDate {

}
