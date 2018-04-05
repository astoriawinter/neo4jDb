package astoria.dummymaker.annotation.string;


import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.string.IdBigGenerator;
import astoria.dummymaker.generator.impl.string.IdGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see IdBigGenerator
 *
 * @author GoodforGod
 * @since 30.05.2017
 */
@PrimeGen(IdGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenId {

}
