package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class MyGamePadOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private Servo myServo;

    // todo: write your code here
    public void runOpMode(){
        telemetry.addData("robot", "initializing");
        telemetry.update();
     
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.x) { 
                telemetry.addData("robot", "x is pressed");
            } else {
                telemetry.addData("robot", "x is not pressed");
            } 
            telemetry.addData("left trigger", gamepad1.left_trigger);
            if(gamepad1.y) {
                telemetry.addData("robot", "y is pressed");
            } else {
                telemetry.addData("robot", "y is not pressed");
            } 
            if(gamepad1.a) {
                telemetry.addData("robot", "a is pressed");
            } else {
                telemetry.addData("robot", "a is not pressed");
            }
            telemetry.addData("right trigger", gamepad1.right_trigger);
            if(gamepad1.b) {
                telemetry.addData("robot", "b is pressed");
            } else {
                telemetry.addData("robot", "b is not pressed");
            }

            telemetry.update();
            }
                
            }
            
        }
    
  
