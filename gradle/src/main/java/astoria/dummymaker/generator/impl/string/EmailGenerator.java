package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.DomainExtensionPresetBundle;
import astoria.dummymaker.bundle.impl.EmailServicesPresetBundle;
import astoria.dummymaker.bundle.impl.NicknamesPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates email as a string
 *
 * @author GoodforGod
 * @since 26.05.2017
 */
public class EmailGenerator implements IGenerator<String> {

    private final IBundle<String> nickBundle = new NicknamesPresetBundle();
    private final IBundle<String> emailBundle = new EmailServicesPresetBundle();
    private final IBundle<String> domainBundle = new DomainExtensionPresetBundle();

    @Override
    public String generate() {
        return nickBundle.getRandom()
                + "@"
                + emailBundle.getRandom()
                + domainBundle.getRandom();
    }
}
