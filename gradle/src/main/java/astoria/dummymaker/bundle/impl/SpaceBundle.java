package astoria.dummymaker.bundle.impl;

import java.util.ArrayList;

public class SpaceBundle extends BasicBundle<String>{
    public SpaceBundle() {
        super(new ArrayList<String>() {{
            add("Software design patterns");
            add("Architectural pattern ");
            add("Software frameworks");
            add("Multimedia frameworks");
            add("Web frameworks");
            add(".NET Framework");
            add("JavaScript web frameworks");
            add("JavaServer Faces");
            add("PHP frameworks");
            add("Web programming");
            add("Python web frameworks");
            add("Rich Internet application frameworks");
            add("Adobe Flash");
            add("ActionScript");
            add(".NET Framework software");
            add("Silverlight");}}
        );
    }
}