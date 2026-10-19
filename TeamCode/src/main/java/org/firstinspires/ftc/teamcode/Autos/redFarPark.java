
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
@Autonomous
public class blue_close
        extends OpMode

    private Follower follower;
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose redFarPark = poseFactory.of(62.4156, 132.8646, 90);
    private final Pose path1 = poseFactory.of(62.2971, 116.7513, -90.4212);
    private final Pose point2 = poseFactory.of(13.3966, 120.0798, -3.894);
    public Path path1() {
        return Paths.line(redFarPark, path1).tangent();
    }

    public Path path2() {
        return Paths.line(path1, point2).reverseTangent();
    }

}

