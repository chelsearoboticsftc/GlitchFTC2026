package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class linear {
    DcMotorEx linear;
    public linear(HardwareMap hardwareMap) {

        this.linear = hardwareMap.get(DcMotorEx.class,"linear");
        linear.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        linear.setDirection(shooterConstants.DIRECTION);


    }

    public void linearSetPower(double power) {linear.setPower(power);}
}

