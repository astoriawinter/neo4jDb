package astoria.dummymaker.annotation.special;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.EmbeddedGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generate object with fields type and populate its fields marked by gen annotations
 *
 * @see astoria.dummymaker.factory.IPopulateFactory
 *
 * @author GoodforGod
 * @since 09.03.2018
 */
@PrimeGen(EmbeddedGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface GenEmbedded {

}
