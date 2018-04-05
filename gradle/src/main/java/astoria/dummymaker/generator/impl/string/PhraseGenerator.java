package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.PhrasePresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates some english phrase as a string
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
public class PhraseGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new PhrasePresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
