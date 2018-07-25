package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import android.graphics.Color;
@Autonomous

public class RunWhenBlue extends OpMode{
    private Gyroscope imu;
    private DcMotor right_Motor;
    private DcMotor left_Motor;
    private LED myLED;
    private DistanceSensor colorDistanceSensor;
    private Servo myServo;
    private ColorSensor colorSensor;
    
    public void init() {
        telemetry.addData("robot", "init");
        telemetry.update();
        colorSensor = hardwareMap.get(ColorSensor.class, "colorDistanceSensor");
        left_Motor = hardwareMap.get(DcMotor.class, "left_Motor");
    }
    public void start() {
        telemetry.addData("robot", "start");
        telemetry.update();
    }
    public void loop() {
        float hsvValues[] = {0F, 0F, 0F};
        int r = colorSensor.red();
        int g = colorSensor.green();
        int b = colorSensor.blue();
        Color.RGBToHSV(r, g, b, hsvValues);
        telemetry.addData("hue", hsvValues[0]);
        telemetry.addData("saturation", hsvValues[1]);
         double hue = hsvValues[0];
        telemetry.addData("values", hsvValues[2]);
        if((hue >=200) && (hue <= 270)) {
            left_Motor.setPower(.25);
        } else { 
            left_Motor.setPower(0);
        }
    }
}
