package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class intakeConstants {

    public static final DcMotor.ZeroPowerBehavior INTAKE_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.FLOAT;
    public static final DcMotor.Direction DIRECTION = DcMotorSimple.Direction.REVERSE;

    //These control the positions for the left Servo


       //These control the positions for the left servo
       public static double liftUpLeft= 1;

       public static double liftDownLeft = 0.7;


    public static double liftUpRight = 1;

    public static double liftDownRight = 0.7;
}

