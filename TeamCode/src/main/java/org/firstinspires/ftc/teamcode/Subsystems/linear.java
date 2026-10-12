package org.firstinspires.ftc.teamcode.Subsystems;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.Subsystems.linearConstants.clawClosed;
import static org.firstinspires.ftc.teamcode.Subsystems.linearConstants.clawOpen;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class linear {
    DcMotorEx linear;
    Servo clawServo;

    public linear(HardwareMap hardwareMap) {

        this.linear = hardwareMap.get(DcMotorEx.class, "linear");
        linear.setZeroPowerBehavior(linearConstants.LINEAR_ZERO_POWER_BEHAVIOR);
        linear.setDirection(linearConstants.DIRECTION);

        this.clawServo = hardwareMap.get(Servo.class, "clawServo");


    }

    public void linearSetPower(double power) {
        linear.setPower(power);


    }

    public void SetPower(double power) {
        linear.setPower(power);
    }

    public void setServoPositionOpen() {
        clawServo.setPosition(clawOpen);

    }

    public void setServoPositionClosed() {
        clawServo.setPosition(clawClosed);

    }


}
