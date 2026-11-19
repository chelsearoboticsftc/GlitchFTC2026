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
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.Subsystems.indexer;
import org.firstinspires.ftc.teamcode.Subsystems.intake;
import org.firstinspires.ftc.teamcode.pedro.Constants;
//import org.firstinspires.ftc.teamcode.Subsystems.Gate;




@Autonomous
public class redAutoHiveUp extends OpMode {

    private Follower follower;
    private Shooter shooter;
    private intake intake;
    private indexer indexer;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(62.3229, 8.5221, 270);
    private final Pose point1 = poseFactory.of(62.1657, 21.6698, 270);
    private final Pose point2Start = poseFactory.of(62.1657, 21.6698, 270);
    private final Pose point2 = poseFactory.of(43.662, 21.6825, 180);
    private final Pose point3Start = poseFactory.of(43.662, 21.6825, 180);
    private final Pose point3 = poseFactory.of(43.3166, 8.3136, 180);
    private final Pose point4Start = poseFactory.of(43.3166, 8.3136, 180);
    private final Pose point4 = poseFactory.of(15.7983, 7.9145, 180);
    private final Pose point5Start = poseFactory.of(15.7983, 7.9145, 180);
    private final Pose point5 = poseFactory.of(15.6048, 90.5623, 0);
    private final Pose point5Control1 = poseFactory.of(42.3865, 70.4831, 0);

    public Path path1() {
        return Paths.line(start, point1).linear(start, point1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.line(point3Start, point3).linear(point3Start, point3);
    }

    public Path path4() {
        return Paths.line(point4Start, point4).linear(point4Start, point4);
    }

    public Path path5() {
        return Paths.curve(point5Start, point5Control1, point5).linear(point5Start, point5);
    }

    public Command autoRoutine() {
        return sequential(
                instant(()-> shooter.shooter1SetVelocity(1435)),
                instant(()-> shooter.shooter2SetVelocity(1435)),
                waitMs(5000),
                instant(()-> indexer.indexerSetPower(1)),
                instant(()-> shooter.setServoPositionUp()),
                waitMs(3000),
                instant(() -> shooter.shooter1SetVelocity(0)),
                instant(() -> shooter.shooter2SetVelocity(0)),
                instant(()-> shooter.setServoPositionDown()),
                instant(()-> indexer.indexerSetPower(0)),
                follow(follower, path1()),
                follow(follower, path2()),
                follow(follower, path3()),
                instant(() -> intake.setServoPositionDown()),
                waitMs(100),
                instant(() -> intake.intakeSetPower(1)),
                instant(()-> indexer.indexerSetPower(1)),
                waitMs(1000),
                follow(follower, path4()),
                follow(follower,path5()));


    }
    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);//sets the starting point of your Robot
        follower.update();
        shooter = new Shooter(hardwareMap);
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