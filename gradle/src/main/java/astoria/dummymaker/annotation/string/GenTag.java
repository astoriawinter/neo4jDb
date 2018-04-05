package astoria.dummymaker.annotation.string;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.string.TagGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see TagGenerator
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
@PrimeGen(TagGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenTag {

}
