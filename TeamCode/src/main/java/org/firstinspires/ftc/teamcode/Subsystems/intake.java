package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class intake {

    DcMotorEx intake;

    public intake(HardwareMap hardwareMap) {

  this.intake = hardwareMap.get(DcMotorEx.class,"intake");
        intake.setZeroPowerBehavior(intakeConstants.INTAKE_ZERO_POWER_BEHAVIOR);
        intake.setDirection(intakeConstants.DIRECTION);


    }

    public void intakeSetPower(double power){
     intake.setPower(power);
    }


}