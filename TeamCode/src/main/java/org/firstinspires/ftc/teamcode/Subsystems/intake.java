package org.firstinspires.ftc.teamcode.Subsystems;
import static org.firstinspires.ftc.teamcode.Subsystems.intakeConstants.liftDown;
import static org.firstinspires.ftc.teamcode.Subsystems.intakeConstants.liftUp;
import static org.firstinspires.ftc.teamcode.Subsystems.linearConstants.clawClosed;
import static org.firstinspires.ftc.teamcode.Subsystems.linearConstants.clawOpen;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.pedro.Constants;

public class intake {

    Servo liftServo;
    DcMotorEx intake;

    public intake(HardwareMap hardwareMap) {


        this.intake = hardwareMap.get(DcMotorEx.class, "intake");
        intake.setZeroPowerBehavior(intakeConstants.INTAKE_ZERO_POWER_BEHAVIOR);
        intake.setDirection(intakeConstants.DIRECTION);

        this.liftServo = hardwareMap.get(Servo.class, "liftServo");
    }

    protected static void setPower(double power) {
    }

    public void intakeSetPower(double power) {
        intake.setPower(power);
    }

    public void SetPower(double power) {
        intake.setPower(power);
    }

    public void setServoPositionUp() {
        liftServo.setPosition(liftUp);

    }

    public void setServoPositionDown() {
        liftServo.setPosition(liftDown);

    }






}



