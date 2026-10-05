package org.firstinspires.ftc.teamcode.TeleOps;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModeStorage;
import org.firstinspires.ftc.teamcode.Subsystems.indexer;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;
import org.firstinspires.ftc.teamcode.Subsystems.intake;

@TeleOp(name = "RoboCentric TeleOp")
public class exampleTeleOpFieldCentric extends OpMode {
private intake intake;
private indexer indexer;
    private Follower follower;
    @Override
    public void start(){
        follower.setPose(OpModeStorage.autonomousEndPose);
        follower.update();
    }
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        intake = new intake(hardwareMap);
        indexer = new indexer(hardwareMap);
    }
    @Override
    public void loop() {
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x,
                follower.pose().heading()
        );
        if (gamepad2.xWasPressed())
            intake.intakeSetPower(1);

        if (gamepad2.xWasReleased())
            intake.intakeSetPower(0);

        if (gamepad2.yWasPressed())
            indexer.indexerSetPower(1);

        if (gamepad2.yWasReleased())
            indexer.indexerSetPower(0);

        follower.manual(powers);
        follower.update();
        Pose robotPose = follower.pose(); // returns a Pose object
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
    }
}