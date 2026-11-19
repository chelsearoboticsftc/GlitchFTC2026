package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;

import com.pedropathing.api.Paths;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.paths.Path;
import org.firstinspires.ftc.teamcode.OpModeStorage;
import com.pedropathing.follower.Follower;


import org.firstinspires.ftc.teamcode.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.Subsystems.indexer;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

@Autonomous
public class blueAutoHiveDown extends OpMode {
    private Follower follower;
    private Shooter shooter;
    private indexer indexer;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(79.7403, 9.6826, 270);
    private final Pose path1 = poseFactory.of(83.0772, 20.4961, 270);
    private final Pose point2 = poseFactory.of(130.4446, 20.5604, -179.9222);

    public Path path1() {
        return Paths.line(start, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.line(path1, point2).reverseTangent();
    }
    private Command autoRoutine() {
        return sequential(
                waitMs(10000),
                instant(() -> shooter.shooter1SetVelocity(-2850)),
                instant(() -> shooter.shooter2SetVelocity(1340)),
                waitMs(5000),
                instant(()-> indexer.indexerSetPower(1)),
                instant(()-> shooter.setServoPositionUp()),
                waitMs(5000),
                instant(() -> shooter.shooter1SetVelocity(0)),
                instant(() -> shooter.shooter2SetVelocity(0)),
                follow(follower, path1()),
                follow(follower, path2()),
                instant(()-> shooter.setServoPositionDown()));



    }

    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);//sets the starting point of your Robot
        follower.update();
        shooter = new Shooter(hardwareMap);
        indexer = new indexer(hardwareMap);

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


       // follower.manual(powers);
        follower.update();

    }}
