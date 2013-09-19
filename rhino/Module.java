package net.sf.robocode.loaders.rhino;

import net.sf.robocode.core.Container;

public class Module {
    static {
        Container.cache.addComponent("robocode.host.rhino", RhinoHost.class);
        Container.cache.addComponent("robocode.host.rhino.robot", RhinoHost.class);
        Container.cache.addComponent("robocode.host.rhino.junior", RhinoHost.class);
        Container.cache.addComponent("robocode.host.rhino.advanced", RhinoHost.class); // default
        Container.cache.addComponent("robocode.host.rhino.team", RhinoHost.class);
        Container.cache.addComponent("robocode.host.rhino.droid", RhinoHost.class);
    }
}
