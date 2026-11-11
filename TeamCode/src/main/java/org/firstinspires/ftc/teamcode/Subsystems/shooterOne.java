package org.firstinspires.ftc.teamcode.Subsystems;

//import android.hardware.

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterOne {

    DcMotorEx shooterOne;


    public shooterOne(HardwareMap hardwareMap) {

        this.shooterOne = hardwareMap.get(DcMotorEx.class, "shooterOne");
        this.shooterOne.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        this.shooterOne.setDirection(DcMotorSimple.Direction.REVERSE);
        this.shooterOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void shooter1SetVelocity(double Velocity) {
        shooterOne.setVelocity(Velocity);

    }

    public double getOneShooterVelocity(){
        return shooterOne.getVelocity();
    }
}