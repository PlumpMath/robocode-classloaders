package net.sf.robocode.loaders.yeti;

import net.sf.robocode.core.Container;

public class Module {
    static {
        Container.cache.addComponent("robocode.host.yeti", YetiHost.class);
    }
}
