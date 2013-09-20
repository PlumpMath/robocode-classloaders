package net.sf.robocode.loaders.rhino;

import robocode.Condition;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.JavaAdapter;


public class RhinoCondition extends Condition {
    private Function f;

    public RhinoCondition(Function func) {
        super();
        f = func;
    }

    public RhinoCondition(String name, Function func) {
        super(name);
        f = func;
    }

    public RhinoCondition(String name, int priority, Function func) {
        super(name, priority);
        f = func;
    }

    public boolean test() {
        return (Boolean) JavaAdapter.callMethod(null, null, f, new Object[]{}, 0);
    }
}
