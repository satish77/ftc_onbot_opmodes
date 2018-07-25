package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import android.graphics.Color;

@Autonomous

public class MyHSV extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private ColorSensor colorDistanceSensor;
    private Servo myServo;
    
    public void runOpMode() {
        telemetry.addData("robot", "initializing");
        telemetry.update();
        colorDistanceSensor = hardwareMap.get(ColorSensor.class, "colorDistanceSensor");
        
        waitForStart();
        while(opModeIsActive()) {
            
            float hsvValues[] = {0F, 0F, 0F};
            int r = colorDistanceSensor.red();
            int g = colorDistanceSensor.green();
            int b = colorDistanceSensor.blue();
            Color.RGBToHSV(r, g, b, hsvValues);
            telemetry.addData("hue", hsvValues[0]);
            telemetry.addData("saturation", hsvValues[1]);
            telemetry.addData("values", hsvValues[2]);
            float hue = hsvValues[0];
            String c;
            if((hue >= 0) && (hue <= 40)){
                c = "red";
            } else if((hue >= 40) && (hue <= 80)) {
                c = "yellow";
            } else if((hue >= 80) && (hue <= 160)) {
                c = "green";
            } else if((hue >= 160) && (hue <= 200)) {
                c = "cyan";
            } else if((hue >=200) && (hue <= 270)) {
                c = "blue";
            } else if((hue >= 270) && (hue <= 330)) {
                c = "purple";
            } else if((hue >= 330) && (hue <= 360)) {
                c = "red";
            } else {
                c = "none";
            }
            telemetry.addData("color detected is", c);
            telemetry.update();
        }
    }
}
