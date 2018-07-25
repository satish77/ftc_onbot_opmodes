package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class MyColorSensorOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private ColorSensor colorSensor;
    private Servo myServo;
    private ElapsedTime et;
    private DistanceSensor distanceSensor;

    public void runOpMode() {
        et = new ElapsedTime();
        et.reset();
        colorSensor = hardwareMap.get(ColorSensor.class, "colorDistanceSensor");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "colorDistanceSensor");
        
        telemetry.addData("Robot", "waiting...");
        telemetry.update();
        
        waitForStart();
        
        while(opModeIsActive()) {
            telemetry.addData("Runtime", et.time());
            telemetry.addData("Distance", distanceSensor.getDistance(DistanceUnit.CM));
            telemetry.addData("RGB", String.format("%d %d %d", colorSensor.red(), colorSensor.green(), colorSensor.blue()));
            telemetry.addData("Alpha", colorSensor.alpha());
            telemetry.addData("argb in hex", String.format("%x", colorSensor.argb()));
            
            telemetry.update();
        }
    }
}
