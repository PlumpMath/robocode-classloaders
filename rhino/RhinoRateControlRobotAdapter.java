package net.sf.robocode.loaders.rhino;

import robocode.RateControlRobot;
import robocode.BulletHitEvent;
import robocode.BulletHitBulletEvent;
import robocode.BulletMissedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.StatusEvent;
import robocode.WinEvent;
import robocode.BattleEndedEvent;
import robocode.RoundEndedEvent;
import robocode.CustomEvent;
import robocode.SkippedTurnEvent;
import robocode.MessageEvent;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;


public class RhinoRateControlRobotAdapter extends RateControlRobot {
    private Context context;
    private Scriptable scope;
    private Scriptable robot;

    public RhinoRateControlRobotAdapter(Context context, Scriptable scope) {
        this.context = context;
        this.scope = scope;
        robot = new NativeJavaObject(scope, this, RhinoRateControlRobotAdapter.class);
	scope.put("self", scope, robot);
    }

    public void run() {
        Function f = JavaAdapter.getFunction(scope, "run");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{});
        }
    }

    // IBasicEvents
    public void onBulletHit(BulletHitEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onBulletHit");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onBulletHitBullet(BulletHitBulletEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onBulletHitBullet");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onBulletMissed(BulletMissedEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onBulletMissed");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onDeath(DeathEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onDeath");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onHitByBullet(HitByBulletEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onHitByBullet");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onHitRobot(HitRobotEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onHitRobot");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onHitWall(HitWallEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onHitWall");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onRobotDeath(RobotDeathEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onRobotDeath");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onScannedRobot(ScannedRobotEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onScannedRobot");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onStatus(StatusEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onStatus");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onWin(WinEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onWin");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    // IBasicEvents2
    public void onBattleEnded(BattleEndedEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onBattleEnded");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    // IBasicEvents3
    public void onRoundEnded(RoundEndedEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onRoundEnded");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    // IInteractiveEvents
    public void onKeyPressed(KeyEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onKeyPressed");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onKeyReleased(KeyEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onKeyReleased");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onKeyTyped(KeyEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onKeyTyped");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseClicked(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseClicked");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseDragged(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseDragged");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseEntered(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseEntered");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseExited(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseExited");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseMoved(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseMoved");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMousePressed(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMousePressed");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseReleased(MouseEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseReleased");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onMouseWheelMoved(MouseWheelEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMouseWheelMoved");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    // IPaintEvents
    public void onPaint(Graphics2D g) {
        Function f = JavaAdapter.getFunction(scope, "onPaint");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{g});
        }
    }

    // IAdvancedEvents
    public void onCustomEvent(CustomEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onCustomEvent");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    public void onSkippedTurn(SkippedTurnEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onSkippedTurn");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }

    // ITeamEvents
    public void onMessageReceived(MessageEvent event) {
        Function f = JavaAdapter.getFunction(scope, "onMessageReceived");
        if (f != null) {
            f.call(context, scope, robot, new Object[]{event});
        }
    }
}
