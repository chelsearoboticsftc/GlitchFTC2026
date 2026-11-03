package org.firstinspires.ftc.teamcode.Subsystems;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.leftGateDown;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.leftGateUp;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.rightGateDown;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.rightGateUp;

import android.health.connect.datatypes.units.Velocity;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class shooter {

    DcMotorEx shooterOne;
    DcMotorEx shooterTwo;
    Servo shooterGateLeft;
    Servo shooterGateRight;

    public shooter(HardwareMap hardwareMap) {

        this.shooterOne = hardwareMap.get(DcMotorEx.class, "shooterOne");
        this.shooterOne.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        this.shooterOne.setDirection(DcMotorSimple.Direction.FORWARD);
        this.shooterOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.shooterTwo = hardwareMap.get(DcMotorEx.class, "shooterTwo");
        this.shooterTwo.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        this.shooterTwo.setDirection(DcMotorSimple.Direction.FORWARD);
        this.shooterTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.shooterGateRight = hardwareMap.get(Servo.class, "shooterGateRight");
        this.shooterGateLeft = hardwareMap.get(Servo.class, "shooterGateLeft");
    }

    public void shooter1SetVelocity(double Velocity) {
        shooterOne.setVelocity(Velocity);
    }
    public void shooter2SetVelocity(double Velocity) {

        shooterTwo.setVelocity(Velocity);
    }

    public void setServoPositionUp() {
        shooterGateLeft.setPosition(leftGateUp);
        shooterGateRight.setPosition(rightGateUp);

    }

    public void setServoPositionDown() {
        shooterGateLeft.setPosition(leftGateDown);
        shooterGateRight.setPosition(rightGateDown);


    }
    public double getOneShooterVelocity(){
        return shooterOne.getVelocity();
    }
    public double getTwoShooterVelocity(){
        return shooterTwo.getVelocity();
    }

}
