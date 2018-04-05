package astoria.dummymaker.scan.container;

import astoria.dummymaker.annotation.PrimeGen;
import astoria.dummymaker.annotation.string.GenString;
import astoria.dummymaker.annotation.time.GenLocalDate;

import java.lang.annotation.Annotation;

/**
 * Container with prime annotation and its child gen annotation
 * Used by populate scanners
 *
 * @see astoria.dummymaker.scan.IPopulateScanner
 * @see PrimeGen
 *
 * @author GoodforGod
 * @since 10.03.2018
 */
public class PopulateContainer {

    /**
     * @see PrimeGen
     */
    private final Annotation prime;

    /**
     * Its child gen annotation like:
     *
     * @see GenString
     * @see GenLocalDate
     */
    private final Annotation gen;

    public PopulateContainer(final Annotation prime,
                             final Annotation gen) {
        this.prime = prime;
        this.gen = gen;
    }

    public Annotation getPrime() {
        return prime;
    }

    public Annotation getGen() {
        return gen;
    }
}
