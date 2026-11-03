package org.firstinspires.ftc.teamcode.Subsystems;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.leftGateDown;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.leftGateUp;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.rightGateDown;
import static org.firstinspires.ftc.teamcode.Subsystems.shooterConstants.rightGateUp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Gate {


    Servo shooterGateLeft;
    Servo shooterGateRight;

    public Gate(HardwareMap hardwareMap) {
        this.shooterGateRight = hardwareMap.get(Servo.class, "shooterGateRight");
        this.shooterGateLeft = hardwareMap.get(Servo.class, "shooterGateLeft");
    }



    public void setServoPositionUp() {
        shooterGateLeft.setPosition(leftGateUp);
        shooterGateRight.setPosition(rightGateUp);

    }


    public void setServoPositionDown() {
        shooterGateLeft.setPosition(leftGateDown);
        shooterGateRight.setPosition(rightGateDown);


    }
}
