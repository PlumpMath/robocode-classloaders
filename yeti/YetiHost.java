package net.sf.robocode.loaders.yeti;

import net.sf.robocode.host.IRobotClassLoader;
import net.sf.robocode.repository.IRobotItem;
import net.sf.robocode.host.JavaHost;

public class YetiHost extends JavaHost {
    public IRobotClassLoader createLoader(IRobotItem robotItem) {
        return new YetiClassLoader(robotItem.getClassPathURL(), robotItem.getFullClassName());
    }
}
