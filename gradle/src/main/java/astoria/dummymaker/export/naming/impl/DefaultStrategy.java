package astoria.dummymaker.export.naming.impl;

import astoria.dummymaker.export.naming.IStrategy;

/**
 * Returns default value as is.
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
public class DefaultStrategy implements IStrategy {

    @Override
    public String toStrategy(String value) {
        return value;
    }
}
