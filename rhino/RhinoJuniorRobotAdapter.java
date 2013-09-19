package net.sf.robocode.loaders.rhino;

import robocode.JuniorRobot;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;


public class RhinoJuniorRobotAdapter extends JuniorRobot {
    private Context context;
    private Scriptable scope;
    private Scriptable robot;

    public RhinoJuniorRobotAdapter(Context context, Scriptable scope) {
        this.context = context;
        this.scope = scope;
        robot = new NativeJavaObject(scope, this, RhinoJuniorRobotAdapter.class);
    }

    public void run() {
        Function f = JavaAdapter.getFunction(scope, "run");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }

    public void onHitByBullet() {
        Function f = JavaAdapter.getFunction(scope, "onHitByBullet");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }

    public void onHitRobot() {
        Function f = JavaAdapter.getFunction(scope, "onHitRobot");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }

    public void onHitWall() {
        Function f = JavaAdapter.getFunction(scope, "onHitWall");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }

    public void onScannedRobot() {
        Function f = JavaAdapter.getFunction(scope, "onScannedRobot");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }
}
