package astoria.dummymaker.export.naming.impl;

import astoria.dummymaker.export.naming.IStrategy;

/**
 * Each upper letter separated with underscore symbol, and transform to upper case
 *
 * EXCLUDING FIRST LETTER, first letter to low case
 *
 * Example: ( DummyList - DUMMY_LIST )
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
public class UnderscoredUpperCaseStrategy implements IStrategy {

    @Override
    public String toStrategy(String value) {
        final StringBuilder builder = new StringBuilder();

        for(final char letter : value.toCharArray()) {
            if (Character.isUpperCase(letter) && builder.length() != 0)
                builder.append("_");

            builder.append(Character.toUpperCase(letter));
        }

        return builder.toString();
    }
}
