package astoria.dummymaker.generator;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.PrimeGen;

/**
 * Generator used by PrimeGen to populate field
 *
 *
 * @see astoria.dummymaker.factory.IPopulateFactory
 * @see PrimeGen
 *
 * @author GoodforGod
 * @since 26.05.2017
 */
public interface IGenerator<T> {
    T generate();
}
