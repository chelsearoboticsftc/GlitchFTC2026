package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class intakeConstants {

    public static final DcMotor.ZeroPowerBehavior INTAKE_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.FLOAT;
    public static final DcMotor.Direction DIRECTION = DcMotorSimple.Direction.REVERSE;

    //These control the positions for the lift Servo


       //These control the positions for the lift servo
       public static double liftUp = 1.0;

       public static double liftDown = 0;


}