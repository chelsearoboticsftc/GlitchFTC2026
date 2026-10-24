package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterConstants {

    public static final DcMotor.ZeroPowerBehavior SHOOTER_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotorSimple.Direction DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static double rightGateUp = 0.9;
    public static double rightGateDown = 0;

    public static double leftGateDown = 1;
    public static double leftGateUp = .1;

}
