package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.TempUnit;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class MyTeleOp extends LinearOpMode {
    private BNO055IMU imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private Servo myServo;

    
    public void runOpMode() {
        telemetry.addData("Robot","initializing");
        telemetry.update();
        
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.mode                = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled      = false;
        
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        
        telemetry.addData("Mode", "calibrating...");
        telemetry.update();
        // make sure the imu gyro is calibrated before continuing.
        while (!isStopRequested() && !imu.isGyroCalibrated())
        {
            sleep(50);
            idle();
        }

        telemetry.addData("Mode", "waiting for start");
        telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
        telemetry.update();
        
        waitForStart();
        
        while(opModeIsActive()) {
            telemetry.addData("Temperature", imu.getTemperature().toUnit(TempUnit.FARENHEIT));
            telemetry.addData("imu", imu.getSystemStatus());
            telemetry.addData("imu calibration status:", imu.getCalibrationStatus());
            telemetry.addData("imu", imu.getAngularOrientation());
            telemetry.update();
        }
    }  
}
