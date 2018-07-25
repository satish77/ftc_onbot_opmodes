package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class MyLoopTime extends OpMode {
    private Gyroscope imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private DistanceSensor colorDistanceSensor;
    private Servo myServo;
    private ElapsedTime et;
    private double minLoopPeriod, maxLoopPeriod;
    
    public void init() {
        telemetry.addData("robot", "init");
        telemetry.update();
        et = new ElapsedTime();
        et.reset();
        }
    public void loop() {
        telemetry.addData("robot", "loop");
        double loopPeriod = et.time();
        et.reset();
        telemetry.addData("loopPeriod", loopPeriod);
        if(loopPeriod < minLoopPeriod) {
            minLoopPeriod = loopPeriod;
        } 
        if(loopPeriod > maxLoopPeriod) {
            maxLoopPeriod = loopPeriod;
        }
        telemetry.addData("min loop period", minLoopPeriod);
        telemetry.addData("max loop period", maxLoopPeriod);
        telemetry.update();
    } 
}
