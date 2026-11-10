package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.OpModeStorage;
import org.firstinspires.ftc.teamcode.Subsystems.indexer;
import org.firstinspires.ftc.teamcode.Subsystems.intake;
import org.firstinspires.ftc.teamcode.Subsystems.shooter;
import org.firstinspires.ftc.teamcode.pedro.Constants;


@Autonomous
public class blueAutoShootFar extends OpMode {
    private Follower follower;
    private shooter shooter;
    private intake intake;
    private indexer indexer;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(79.5833, 132.7654, 90);
    private final Pose path1 = poseFactory.of(98.3627, 125.9661, 0);
    private final Pose path1Control1 = poseFactory.of(82.4806, 105.0331, 0);
    private final Pose point2Start = poseFactory.of(98.3627, 125.9661, 0);
    private final Pose point2 = poseFactory.of(128.4622, 132.2786, 0);
    private final Pose point2Control1 = poseFactory.of(103.2313, 133.1319, 0);
    private final Pose point3Start = poseFactory.of(128.4622, 132.2786, 0);
    private final Pose point3 = poseFactory.of(132.9221, 50.8324, 0);
    private final Pose point3Control1 = poseFactory.of(103.5622, 58.4681, 0);

    public Path path1() {
        return Paths.curve(start, path1Control1, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.curve(point2Start, point2Control1, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.curve(point3Start, point3Control1, point3).linear(point3Start, point3);
    }
    private Command autoRoutine() {
        return sequential(

                instant(()-> shooter.shooter1SetVelocity(1435)),
                instant(()-> shooter.shooter2SetVelocity(1435)),
                waitMs(4000),
                instant(()-> indexer.indexerSetPower(1)),
                instant(()-> shooter.setServoPositionUp()),
                waitMs(5000),
                instant(() -> shooter.shooter1SetVelocity(0)),
                instant(() -> shooter.shooter2SetVelocity(0)),
                instant(()-> shooter.setServoPositionDown()),
                instant(()-> indexer.indexerSetPower(0)),
                follow(follower, path1()),
                instant(() -> intake.setServoPositionDown()),
                waitMs(100),
                instant(() -> intake.intakeSetPower(1)),
                instant(()-> indexer.indexerSetPower(1)),
                waitMs(100),
                follow(follower, path2()),
                follow(follower, path3()));


    }

    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);//sets the starting point of your Robot
        follower.update();
        shooter = new shooter(hardwareMap);
        indexer = new indexer(hardwareMap);
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
        Pose robotPose = follower.pose(); // returns a Pose object
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
        telemetry.update();
    }

    @Override
    public void stop() {
        OpModeStorage.autonomousEndPose = follower.pose(); //saves your position in that file


//            follower.manual(powers);
            follower.update();

}}




