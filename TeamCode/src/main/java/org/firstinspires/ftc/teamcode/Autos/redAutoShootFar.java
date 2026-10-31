

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

        private final Pose start = poseFactory.of(62.3326, 133.3411, 90);
        private final Pose path1 = poseFactory.of(12.9822, 123.1273, 0);
        private final Pose path1Control1 = poseFactory.of(65.7263, 111.5634, 0);

        public Path path1() {
            return Paths.curve(start, path1Control1, path1).linear(start, path1);
        }
    }


    public Path path2() {
        return Paths.Line(path1, point2).tangent();
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

                follow(follower, path1()),;


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

