package net.sf.robocode.loaders.rhino;

import robocode.Droid;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class RhinoDroidRobotAdapter extends RhinoTeamRobotAdapter implements Droid {
    public RhinoDroidRobotAdapter(Context context, Scriptable scope) {
        super(context, scope);
    }
};
