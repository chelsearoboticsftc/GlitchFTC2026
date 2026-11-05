package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooterConstants {

    public static final DcMotor.ZeroPowerBehavior SHOOTER_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.FLOAT;

    public static final DcMotorSimple.Direction DIRECTION_1 = DcMotorSimple.Direction.FORWARD;
    public static final DcMotorSimple.Direction DIRECTION_2 = DcMotorSimple.Direction.FORWARD;
    public static double rightGateUp = 0.3;  //This is the down
    public static double rightGateDown = 0.65;  //This is the up

    public static double leftGateDown = 0.3;  //This is the down
    public static double leftGateUp = 0.65;   //This is the up

}
