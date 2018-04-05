package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.NounPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * "default comment"
 *
 * @author GoodforGod
 * @since 21.02.2018
 */
public class NounGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new NounPresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
