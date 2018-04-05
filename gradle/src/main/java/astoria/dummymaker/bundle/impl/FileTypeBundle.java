package astoria.dummymaker.bundle.impl;

import java.util.ArrayList;

public class FileTypeBundle extends BasicBundle<String>{
    public FileTypeBundle() {
        super(new ArrayList<String>() {{
            add("IMAGE");
            add("AUDIO");
            add("VIDEO");}}
        );
    }
}