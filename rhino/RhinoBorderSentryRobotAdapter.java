package net.sf.robocode.loaders.rhino;

import robocode.BorderSentry;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class RhinoBorderSentryRobotAdapter extends RhinoRateControlRobotAdapter implements BorderSentry {
    public RhinoBorderSentryRobotAdapter(Context context, Scriptable scope) {
        super(context, scope);
    }
};
