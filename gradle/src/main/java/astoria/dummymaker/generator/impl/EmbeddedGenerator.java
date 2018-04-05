package astoria.dummymaker.generator.impl;

import astoria.dummymaker.annotation.special.GenEmbedded;
import astoria.dummymaker.generator.IGenerator;

/**
 * Used as a marker generator for embedded annotation
 *
 * @see GenEmbedded
 *
 * @author GoodforGod
 * @since 09.03.2018
 */
public class EmbeddedGenerator implements IGenerator<Object> {

    @Override
    public Object generate() {
        return null;
    }
}
