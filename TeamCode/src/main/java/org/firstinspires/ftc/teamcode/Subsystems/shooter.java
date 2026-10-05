package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooter {

    DcMotorEx shooter;

    public shooter(HardwareMap hardwareMap) {

        this.shooter = hardwareMap.get(DcMotorEx.class,"shooter");
        shooter.setZeroPowerBehavior(shooterConstants.SHOOTER_ZERO_POWER_BEHAVIOR);
        shooter.setDirection(shooterConstants.DIRECTION);


    }

    public void shooterSetPower(double power) {shooter.setPower(power);}
}
