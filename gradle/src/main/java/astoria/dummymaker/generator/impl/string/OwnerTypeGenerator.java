package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.OwnerTypeBundle;
import astoria.dummymaker.generator.IGenerator;

public class OwnerTypeGenerator implements IGenerator<String> {
    private final IBundle<String> bundle = new OwnerTypeBundle();
    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
