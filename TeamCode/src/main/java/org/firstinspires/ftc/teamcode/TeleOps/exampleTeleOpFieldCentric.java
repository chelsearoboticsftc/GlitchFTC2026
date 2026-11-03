package org.firstinspires.ftc.teamcode.TeleOps;
import android.annotation.SuppressLint;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModeStorage;
import org.firstinspires.ftc.teamcode.Subsystems.Gate;
import org.firstinspires.ftc.teamcode.Subsystems.indexer;
import org.firstinspires.ftc.teamcode.Subsystems.shooterOne;
import org.firstinspires.ftc.teamcode.Subsystems.shooterTwo;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;

import org.firstinspires.ftc.teamcode.Subsystems.intake;

@TeleOp(name = "FieldCentric TeleOp")
public class exampleTeleOpFieldCentric extends OpMode {
private intake intake;
private indexer indexer;
private shooterOne shooterOne;
private shooterTwo shooterTwo;
private Gate gate;



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
        shooterOne = new shooterOne(hardwareMap);
        shooterTwo = new shooterTwo(hardwareMap);
        gate = new Gate(hardwareMap);


    }
    @SuppressLint("SuspiciousIndentation")
    @Override
    public void loop() {
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()
        );

        if (gamepad1.bWasPressed()) {
            intake.intakeSetPower(1);
            indexer.indexerSetPower(1);
        }


        if (gamepad2.bWasReleased()) {
            intake.intakeSetPower(0);
            indexer.indexerSetPower(0);
        }

        if (gamepad2.yWasPressed()) {
            indexer.indexerSetPower(1);
        }

        if (gamepad2.yWasReleased()) {
            indexer.indexerSetPower(0);
        }


        if (gamepad2.right_trigger> .25) {
            shooterOne.shooter1SetVelocity(-1000);
            shooterTwo.shooter2SetVelocity(1000);
        }

        if (gamepad2.right_trigger<.25) {
            shooterOne.shooter1SetVelocity(0);
            shooterTwo.shooter2SetVelocity(0);
        }


        if (gamepad2.rightBumperWasPressed()) {
            intake.setServoPositionUp();
        }

        if (gamepad2.rightBumperWasReleased()) {
            intake.setServoPositionDown();
        }

        if (gamepad2.leftBumperWasPressed()) {
            intake.setServoPositionDown();
        }

        if (gamepad2.leftBumperWasReleased()) {
            intake.setServoPositionUp();}

        if (gamepad2.xWasPressed()) {
            telemetry.addLine("buttonPressed");
            gate.setServoPositionUp();
            indexer.indexerSetPower(1);}



            if (gamepad2.xWasReleased()) {
                telemetry.addLine("buttonReleased");
                gate.setServoPositionDown();
                indexer.indexerSetPower(0);
            }


            follower.manual(powers);
            follower.update();
            Pose robotPose = follower.pose(); // returns a Pose object
            telemetry.addData("Robot X", robotPose.x());
            telemetry.addData("Robot Y", robotPose.y());
            telemetry.addData("Shooter 1 Velocity", shooterOne.getOneShooterVelocity());
            telemetry.addData("Shooter 2 Velocity", shooterTwo.getTwoShooterVelocity());
            telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
            //telemetry.addData("direction", shooter.getShooterOne());
           // telemetry.addData("direction", shooter.getShooterTwo());
            telemetry.update();
        }}
