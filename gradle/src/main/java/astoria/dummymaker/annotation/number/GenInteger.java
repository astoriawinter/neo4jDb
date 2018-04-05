package astoria.dummymaker.annotation.number;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.number.IntegerGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see IntegerGenerator
 *
 * @author GoodforGod
 * @since 30.05.2017
 */
@PrimeGen(IntegerGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenInteger {

}
