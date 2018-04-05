package astoria.dummymaker.factory.impl;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.factory.IProduceFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static astoria.dummymaker.util.BasicCastUtils.instanceClass;

/**
 * Produce Dummy Objects and populate them via PrimeGen generators included
 *
 * @see PrimeGen
 *
 * @author GoodforGod
 * @since 26.05.2017
 */
public class GenProduceFactory implements IProduceFactory {

    private final IPopulateFactory populateFactory;

    public GenProduceFactory() {
        this.populateFactory = new GenPopulateFactory();
    }

    @Override
    public <T> T produce(final Class<T> tClass) {
        return populateFactory.populate(instanceClass(tClass));
    }

    @Override
    public <T> List<T> produce(final Class<T> tClass, final int amount) {
        if (amount < 1)
            return Collections.emptyList();

        final List<T> produced = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            final T t = instanceClass(tClass);
            if (t == null)
                return Collections.emptyList();

            produced.add(t);
        }

        return populateFactory.populate(produced);
    }
}
