package astoria.dummymaker.bundle.impl;

import java.util.ArrayList;

public class OwnerTypeBundle extends BasicBundle<String>{
    public OwnerTypeBundle() {
        super(new ArrayList<String>() {{
            add("READ");
            add("MODIFY");
            add("ADMIN");}}
        );
    }
}