package astoria.dummymaker.generator.impl.number;

import astoria.dummymaker.generator.IGenerator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Generates simple integer
 *
 * @author GoodforGod
 * @since 26.05.2017
 */
public class IntegerGenerator implements IGenerator<Integer> {

    @Override
    public Integer generate() {
        return ThreadLocalRandom.current().nextInt();
    }
}
