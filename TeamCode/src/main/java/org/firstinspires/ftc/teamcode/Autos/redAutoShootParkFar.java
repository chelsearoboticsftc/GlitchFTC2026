<<<<<<< HEAD
//package org.firstinspires.ftc.teamcode.Autos;
//
//import android.graphics.Path;
//
//import com.pedropathing.api.PoseFactory;
//import com.pedropathing.math.Pose;
//import com.pedropathing.paths.curves.Line;
//import static com.pedropathing.api.Paths.;
//import com.pedropathing.api.Paths;
//
//import com.pedropathing.api.PoseFactory;
//import com.pedropathing.math.Pose;
//
//public class redAutoShootParkFar
//
//public class Paths {
//
//    private final PoseFactory poseFactory = PoseFactory.degrees();
//
//    private final Pose start = poseFactory.of(60.0668, 133.0149, 90);
//    private final Pose path1 = poseFactory.of(59.0615, 111.2825, -92.6485);
//    private final Pose point2 = poseFactory.of(17.106, 121.1152, 166.8103);
//
//    public Path path1() {
//        return Paths.Line(start, path1).tangent();
//    }
//
//    public Path path2() {
//        return Paths.Line(path1, point2).tangent();
//    }
//  }
//}
=======
package org.firstinspires.ftc.teamcode.Autos;


import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.OpModeStorage;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.shooter;

@Autonomous
public class redAutoShootParkFar extends OpMode{



    private Follower follower;
    private shooter shooter;
public class Paths {

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose redAutoShootParkFar = poseFactory.of(60.0668, 133.0149, 90);
    private final Pose path1 = poseFactory.of(59.0615, 111.2825, -92.6485);
    private final Pose point2 = poseFactory.of(17.106, 121.1152, 166.8103);

    public Path path1() {
        return Paths.Line(start, path1).tangent();
    }

    public Path path2() {
        return Paths.Line(path1, point2).tangent();
    }



  }



    public Path path1() {
        return com.pedropathing.api.Paths.line(redAutoShootParkFar, path1).tangent();
    }

    public Path path2() {
        return com.pedropathing.api.Paths.line(path1, point2).reverseTangent();
    }

    public Command autoRoutine() {
        return sequential(
                //instant(() -> shooter.setVelocity(2000)),
                waitMs(3000),
                //instant(() -> shooter.setVelocity(0)),

                follow(follower, path1()),
                follow(follower, path2()));

    }

    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(redAutoShootParkFar);//sets the starting point of your Robot
        follower.update();

    }

    @Override
    public void start() {
        schedule(autoRoutine());
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }

    @Override
    public void stop() {
        OpModeStorage.autonomousEndPose = follower.pose(); //saves your position in that file
    }

}
