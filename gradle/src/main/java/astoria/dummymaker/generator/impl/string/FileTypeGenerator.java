package astoria.dummymaker.generator.impl.string;

import astoria.dummymaker.bundle.IBundle;
import astoria.dummymaker.bundle.impl.FileTypeBundle;
import astoria.dummymaker.bundle.impl.OwnerTypeBundle;
import astoria.dummymaker.generator.IGenerator;

public class FileTypeGenerator implements IGenerator<String> {
    private final IBundle<String> bundle = new FileTypeBundle();
    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
