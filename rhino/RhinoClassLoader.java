package net.sf.robocode.loaders.rhino;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.HashSet;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeJavaClass;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

import robocode.Rules;
import robocode.GunTurnCompleteCondition;
import robocode.MoveCompleteCondition;
import robocode.RadarTurnCompleteCondition;
import robocode.TurnCompleteCondition;
import robocode.robotinterfaces.IAdvancedRobot;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.IInteractiveRobot;
import robocode.robotinterfaces.IPaintRobot;
import robocode.util.Utils;

import net.sf.robocode.host.security.RobotClassLoader;


public class RhinoClassLoader extends RobotClassLoader {
    protected final String robotPlatform;

    public RhinoClassLoader(URL robotClassPath, String robotFullClassName, String robotPlatform) {
        super(robotClassPath, robotFullClassName);
        this.robotPlatform = robotPlatform;
    }

    public synchronized Class<?> loadRobotMainClass(boolean resolve) throws ClassNotFoundException {
        super.loadRobotMainClass(resolve);
        return getAdapterClass();
    }

    public IBasicRobot createRobotInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> robotClass = super.loadRobotMainClass(true);
        Class<?> clazz = loadRobotMainClass(true);

        Context context = Context.enter();
        Scriptable scope = new ImporterTopLevel(context);
        initGlobalScope(context, scope);

        final Script script = (Script)robotClass.newInstance();
        script.exec(context, scope);

        try {
            return (IBasicRobot)clazz.getConstructor(Context.class, Scriptable.class).newInstance(context, scope);
        } catch (NoSuchMethodException e) {
        } catch (java.lang.reflect.InvocationTargetException e) {
        }
        return null;
    }

    public Class<?> getAdapterClass() {
        if (robotPlatform.equals("rhino.robot")) {
            return RhinoRobotAdapter.class;
        } else if (robotPlatform.equals("rhino.junior")) {
            return RhinoJuniorRobotAdapter.class;
        } else if (robotPlatform.equals("rhino.team")) {
            return RhinoTeamRobotAdapter.class;
        } else if (robotPlatform.equals("rhino.droid")) {
            return RhinoDroidRobotAdapter.class;
        } else {
            return RhinoAdvancedRobotAdapter.class;
        }
    }

    public void initGlobalScope(Context context, Scriptable scope) {
        scope.put("Rules", scope, new NativeJavaClass(scope, Rules.class));
        scope.put("Utils", scope, new NativeJavaClass(scope, Utils.class));

        Class<?> clazz = getAdapterClass();

        if (IPaintRobot.class.isAssignableFrom(clazz)) {
            scope.put("Color", scope, new NativeJavaClass(scope, Color.class));
        }

        if (IInteractiveRobot.class.isAssignableFrom(clazz)) {
            scope.put("KeyEvent", scope, new NativeJavaClass(scope, KeyEvent.class));
            scope.put("MouseEvent", scope, new NativeJavaClass(scope, MouseEvent.class));
        }

        if (IAdvancedRobot.class.isAssignableFrom(clazz)) {
            scope.put("Condition", scope, new NativeJavaClass(scope, RhinoCondition.class));
            scope.put("GunTurnCompleteCondition", scope, new NativeJavaClass(scope, GunTurnCompleteCondition.class));
            scope.put("MoveCompleteCondition", scope, new NativeJavaClass(scope, MoveCompleteCondition.class));
            scope.put("RadarTurnCompleteCondition", scope, new NativeJavaClass(scope, RadarTurnCompleteCondition.class));
            scope.put("TurnCompleteCondition", scope, new NativeJavaClass(scope, TurnCompleteCondition.class));
        }
    }
};
