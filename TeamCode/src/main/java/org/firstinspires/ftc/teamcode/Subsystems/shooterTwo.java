package org.firstinspires.ftc.teamcode.Subsystems;

import android.health.connect.datatypes.units.Velocity;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterTwo {

    DcMotorEx shooterTwo;

    public shooterTwo(HardwareMap hardwareMap) {
        this.shooterTwo = hardwareMap.get(DcMotorEx.class, "shooterTwo");
        this.shooterTwo.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        this.shooterTwo.setDirection(DcMotorSimple.Direction.FORWARD);
        this.shooterTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void shooter2SetVelocity(double Velocity) {

        shooterTwo.setVelocity(Velocity);
    }

    public double getTwoShooterVelocity() {
        return shooterTwo.getVelocity();
    }

}