package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.CompanyPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates company name as a string
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
public class CompanyGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new CompanyPresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
