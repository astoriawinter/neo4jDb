package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.PageBundle;
import astoria.dummymaker.generator.IGenerator;

public class PageGenerator implements IGenerator<String> {
    private final IBundle<String> pageGenerator = new PageBundle();
    @Override
    public String generate() {
        return pageGenerator.getRandom();
    }
}
