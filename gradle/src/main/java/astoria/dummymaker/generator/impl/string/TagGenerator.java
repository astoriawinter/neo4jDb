package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.TagPresetBundle;
import astoria.dummymaker.generator.IGenerator;

/**
 * Generates tag as a string like #tag
 *
 * @author GoodforGod (Anton Kurako)
 * @since 07.06.2017
 */
public class TagGenerator implements IGenerator<String> {

    private final IBundle<String> bundle = new TagPresetBundle();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
