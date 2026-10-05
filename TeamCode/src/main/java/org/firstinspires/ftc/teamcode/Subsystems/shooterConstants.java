package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterConstants {

    public static final DcMotor.ZeroPowerBehavior SHOOTER_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotorSimple.Direction DIRECTION = DcMotorSimple.Direction.FORWARD;
}
