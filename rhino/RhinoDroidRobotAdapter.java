package net.sf.robocode.loaders.rhino;

import robocode.Droid;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class RhinoDroidRobotAdapter extends RhinoRateControlRobotAdapter implements Droid {
    public RhinoDroidRobotAdapter(Context context, Scriptable scope) {
        super(context, scope);
    }
};
