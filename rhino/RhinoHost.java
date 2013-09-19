package net.sf.robocode.loaders.rhino;

import net.sf.robocode.host.IRobotClassLoader;
import net.sf.robocode.repository.IRobotItem;
import net.sf.robocode.host.JavaHost;

public class RhinoHost extends JavaHost {
    public IRobotClassLoader createLoader(IRobotItem robotItem) {
        return new RhinoClassLoader(robotItem.getClassPathURL(),
                                    robotItem.getFullClassName(),
                                    robotItem.getPlatform().toLowerCase());
    }
}
