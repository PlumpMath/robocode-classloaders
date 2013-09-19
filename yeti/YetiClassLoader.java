package net.sf.robocode.loaders.yeti;

import net.sf.robocode.loaders.RobotClassLoader;

import java.net.URL;


public class YetiClassLoader extends RobotClassLoader {

    public YetiClassLoader(URL robotClassPath, String robotFullClassName) {
        super(robotClassPath, robotFullClassName);
    }

    protected boolean isLanguageLibraryClass(final String name) {
        return name.startsWith("yeti.lang") || super.isLanguageLibraryClass(name);
    }

    protected boolean isSystemClass(String className) {
        return className.startsWith("yeti.") || super.isSystemClass(className);
    }
}
