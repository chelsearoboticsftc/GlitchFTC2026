package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.ivy.Scheduler.schedule;
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
import org.firstinspires.ftc.teamcode.Subsystems.shooter;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@Autonomous
public class blueCloseShootPark extends OpMode{

    private Follower follower;

    private shooter shooter;

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose start = poseFactory.of(79.31, 8.4585, 270);
        private final Pose path1 = poseFactory.of(132.3169, 22.4463, 180);
        private final Pose path1Control1 = poseFactory.of(85.6619, 33.2731, 0);

        public Path path1() {
            return Paths.curve(start, path1Control1, path1).linear(start, path1);
        }






    public Command autoRoutine() {
        return sequential(
                //instant(() -> shooter.setVelocity(2000)),
                waitMs(3000),
                //instant(() -> shooter.setVelocity(0)),

                follow(follower, path1()));




        follower.setPose(blueCloseShootPark);//sets the starting point of your Robot
        follower.update();

    }


    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(blueCloseShootPark);//sets the starting point of your Robot
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
    }}
