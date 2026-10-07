package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class intake {

    DcMotorEx intake;public intake(HardwareMap hardwareMap) {

  this.intake = hardwareMap.get(DcMotorEx.class,"intake");
        intake.setZeroPowerBehavior(intakeConstants.INTAKE_ZERO_POWER_BEHAVIOR);
        intake.setDirection(intakeConstants.DIRECTION);
        this.intakeLiftLeft = hardwareMap.get(Servo.class,"intakeLiftLeft");
        intakeLiftLeft.


    }

    public void intakeSetPower(double power){
     intake.setPower(power);
    }
public void intakeSetPosition

}