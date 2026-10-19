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
public class redAutoShootClose extends OpMode {

    private Follower follower;
    private shooter shooter;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose redAutoShootClose = poseFactory.of(58.6107, 8.5221, 90);
    private final Pose point1 = poseFactory.of(33.1232, 9.223, 0);
    private final Pose point1Control1 = poseFactory.of(58.6015, 39.1144, 0);
    private final Pose point2 = poseFactory.of(7.8466, 8.8203, 0.9129);
    private final Pose point3Start = poseFactory.of(7.8466, 8.8203, 0);
    private final Pose point3 = poseFactory.of(10.0665, 105.7546, 0);
    private final Pose point3Control1 = poseFactory.of(45.3266, 51.31, 0);


    public Path path1() {
        return Paths.curve(redAutoShootClose, point1Control1, point1).linear(redAutoShootClose, point1);
    }

    public Path path2() {
        return Paths.line(point1, point2).reverseTangent();
    }

    public Path path3() {
        return Paths.curve(point3Start, point3Control1, point3).linear(point3Start, point3);
    }

    public Command autoRoutine() {
        return sequential(
                //instant(() -> shooter.setVelocity(2000)),
                waitMs(3000),
                //instant(() -> shooter.setVelocity(0)),


                follow(follower, path1()),
                follow(follower, path2()),
                follow(follower, path3()));


    }
    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(redAutoShootClose);//sets the starting point of your Robot
        follower.update();
        shooter = new shooter(hardwareMap);
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