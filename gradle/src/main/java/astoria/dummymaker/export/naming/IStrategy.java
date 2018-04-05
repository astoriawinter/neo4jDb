package astoria.dummymaker.export.naming;

/**
 * Allow to apply naming strategy for field names or class name during export
 *
 * @see astoria.dummymaker.export.IExporter
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
public interface IStrategy {

    /**
     * Format value using naming strategy
     *
     * @param value value to formatted via strategy
     * @return formatted value
     */
    String toStrategy(final String value);
}
