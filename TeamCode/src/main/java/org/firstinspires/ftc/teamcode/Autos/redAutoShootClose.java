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
import org.firstinspires.ftc.teamcode.Subsystems.intake;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.shooter;




@Autonomous
public class redAutoShootClose extends OpMode {

    private Follower follower;
    private shooter shooter;
    private intake intake;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(62.3229, 8.5221, 270);
    private final Pose point1 = poseFactory.of(33.56, 9.6598, 0);
    private final Pose point1Control1 = poseFactory.of(58.6015, 39.1144, 0);
    private final Pose point2Start = poseFactory.of(33.56, 9.6598, 0);
    private final Pose point2 = poseFactory.of(13.524, 9.4754, 0);
    private final Pose point3Start = poseFactory.of(13.524, 9.4754, 0);
    private final Pose point3 = poseFactory.of(10.0665, 105.7546, 0);
    private final Pose point3Control1 = poseFactory.of(49.6938, 55.6773, 0);

    public Path path1() {
        return Paths.curve(start, point1Control1, point1).linear(start, point1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.curve(point3Start, point3Control1, point3).linear(point3Start, point3);
    }

    public Command autoRoutine() {
        return sequential(
                //instant(() -> shooter.shooterSetVelocity(965)),
                waitMs(3000),
                //instant(() -> shooter.shooterSetVelocity(0)),


                follow(follower, path1()),
                instant(() ->intake.intakeSetPower(1)),
                waitMs(100),
                follow(follower, path2()),
                instant(()->intake.intakeSetPower(0)),
                follow(follower, path3()));


    }
    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);//sets the starting point of your Robot
        follower.update();
        shooter = new shooter(hardwareMap);
        intake = new intake(hardwareMap);
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