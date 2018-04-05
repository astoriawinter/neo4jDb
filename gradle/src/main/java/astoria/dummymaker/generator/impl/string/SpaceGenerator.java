package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.SpaceBundle;
import astoria.dummymaker.generator.IGenerator;

public class SpaceGenerator implements IGenerator<String> {
    private final IBundle<String> bundle = new SpaceBundle();
    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
