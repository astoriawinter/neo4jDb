package astoria.dummymaker.annotation.string;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.generator.impl.string.OwnerTypeGenerator;
import astoria.dummymaker.generator.impl.string.SpaceGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@PrimeGen(SpaceGenerator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenSpaceType {
}
