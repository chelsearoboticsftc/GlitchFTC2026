package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class linearConstants {
    public static final DcMotor.ZeroPowerBehavior LINEAR_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotorSimple.Direction DIRECTION = DcMotorSimple.Direction.REVERSE;





    //These control the positions for the claw Servo
    public static double clawOpen = 1.0;

    public static double clawClosed = 0;
}

