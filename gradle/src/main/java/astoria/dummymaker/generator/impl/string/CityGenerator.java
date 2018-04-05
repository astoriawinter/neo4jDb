package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.CityPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates city in english as a string
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
public class CityGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new CityPresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
