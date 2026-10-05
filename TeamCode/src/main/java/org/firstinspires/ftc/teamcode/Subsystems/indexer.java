package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class indexer {

    DcMotorEx indexer;

    public indexer(HardwareMap hardwareMap) {

        this.indexer = hardwareMap.get(DcMotorEx.class,"indexer");
        indexer.setZeroPowerBehavior(indexerConstants.INDEXER_ZERO_POWER_BEHAVIOR);
        indexer.setDirection(indexerConstants.DIRECTION);
    }

    public void setIndexer(double power) {indexer.setPower(power);}
}
