package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
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
//    private servoGateRight servoGateRight;
//    private servoGateLeft servoGateLeft;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(79.5833, 132.7654, 90);
    private final Pose path1 = poseFactory.of(98.581, 125.311, 0);
    private final Pose point2Start = poseFactory.of(98.581, 125.311, 0);
    private final Pose point2 = poseFactory.of(133.6018, 133.2491, 0);
    private final Pose point2Control1 = poseFactory.of(103.2313, 135.7523, 0);
    private final Pose point3Start = poseFactory.of(133.6018, 133.2491, 0);
    private final Pose point3 = poseFactory.of(132.9221, 50.8324, 0);
    private final Pose point3Control1 = poseFactory.of(114.9171, 60.8701, 0);

    public Path path1() {
        return Paths.line(start, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.curve(point2Start, point2Control1, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.curve(point3Start, point3Control1, point3).linear(point3Start, point3);
    }
    private Command autoRoutine() {
        return sequential(

               // instant(()-> shooter.shooterSetVelocity(965)),
                instant(()-> indexer.indexerSetPower(1)),
//                instant())-> servoGateRight.setServoPositionUp,
//                instant())-> servoGateLeft.setServoPositionUp,

                waitMs(3000),
                //instant(() -> shooter.shooterSetVelocity(0)),
                instant(()-> indexer.indexerSetPower(0)),

                follow(follower, path1()),
                instant(() -> intake.intakeSetPower(1)),
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
