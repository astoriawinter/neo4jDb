package astoria.dummymaker.export.naming.impl;

import astoria.dummymaker.export.naming.IStrategy;

/**
 * First letter is low case, next letters are as is: Bobby - bobby, TonNy - tonNy
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
public class InitialLowCaseStrategy implements IStrategy {

    @Override
    public String toStrategy(String value) {
        return (value.length() == 1)
                ? value.toLowerCase()
                : value.substring(0, 1).toLowerCase() + value.substring(1, value.length());
    }
}
