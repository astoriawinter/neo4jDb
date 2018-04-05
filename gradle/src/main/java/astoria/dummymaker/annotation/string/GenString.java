package astoria.dummymaker.annotation.string;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.string.StringGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * "default comment"
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
@PrimeGen(StringGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenString {

}
