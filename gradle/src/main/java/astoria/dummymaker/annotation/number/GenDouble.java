package astoria.dummymaker.annotation.number;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.number.DoubleGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see DoubleGenerator
 *
 * @author GoodforGod
 * @since 30.05.2017
 */
@PrimeGen(DoubleGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenDouble {

}
