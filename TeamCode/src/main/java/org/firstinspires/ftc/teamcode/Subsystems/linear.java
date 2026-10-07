package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class linear {
    DcMotorEx linear;
    public linear(HardwareMap hardwareMap) {

        this.linear = hardwareMap.get(DcMotorEx.class,"linear");
        linear.setZeroPowerBehavior(linearConstants.LINEAR_ZERO_POWER_BEHAVIOR);
        linear.setDirection(linearConstants.DIRECTION);


    }

    public void linearSetPower(double power) {linear.setPower(power);}

    public void setServoPositionOpen(){
        clawServo.setPosition CLAWOPEN;

    }
    public void setServoPositionClosed(){
        clawServo.setPosition CLAWCLOSED;
    }
}


