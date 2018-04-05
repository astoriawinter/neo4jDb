package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.CountryPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates country as a string
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
public class CountryGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new CountryPresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
