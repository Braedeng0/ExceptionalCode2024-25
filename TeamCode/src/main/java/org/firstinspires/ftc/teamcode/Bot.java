package org.firstinspires.ftc.teamcode;


import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Hardware.BotIMU;
import org.firstinspires.ftc.teamcode.Hardware.Collector;
import org.firstinspires.ftc.teamcode.Hardware.LEDController;
import org.firstinspires.ftc.teamcode.Hardware.LinearSlide;
import org.firstinspires.ftc.teamcode.Hardware.MecanumBase;
import org.firstinspires.ftc.teamcode.Hardware.ServoClass;
import org.firstinspires.ftc.teamcode.Hardware.VoltageHandler;
import org.firstinspires.ftc.teamcode.Helpers.Commands;
import org.firstinspires.ftc.teamcode.SelfDrivingAuto.PIDController;
import org.firstinspires.ftc.teamcode.SelfDrivingAuto.Pose;

/**
 * This class is used to create all of the hardware objects and store them in the bot object
 * This is used to simplify the code and make it easier to read
 * This also makes it easier to create new objects
 */
public class Bot {
    public Commands commands;
    public PIDController pidController;
    public BotIMU imu;
    public LinearSlide slide;
    public LEDController led;
    public MecanumBase mecanumBase;
    public Pose pose;
    public VoltageHandler voltageHandler;
    public Collector collector;
    public WebcamName webcam;
    public ServoClass pixelDropLeft, pixelDropRight, gripper, wrist;

    /**
     * Constructor for Bot.
     * @param opMode LinearOpMode
     */
    public Bot(@NonNull LinearOpMode opMode){
        // Define webcam before pose
        webcam = opMode.hardwareMap.get(WebcamName.class, Config.webcam);

        // Drive base and self driving
        pose = new Pose(opMode, this); // Needs to be initialized before pidController
        mecanumBase = new MecanumBase(opMode, this);
        pidController = new PIDController(opMode, this); // Uses the same pose object as the bot

        // Motors
        slide = new LinearSlide(opMode);
        collector = new Collector(opMode);

        // Servos
        pixelDropLeft = new ServoClass(opMode.hardwareMap.get(Servo.class, Config.leftDropServo), Config.leftOpenPos, Config.leftClosedPos, Config.leftClosedPos);
        pixelDropRight = new ServoClass(opMode.hardwareMap.get(Servo.class, Config.rightDropServo), Config.rightOpenPos, Config.rightClosedPos, Config.rightClosedPos);
        gripper = new ServoClass(opMode.hardwareMap.get(Servo.class, Config.gripperServo), Config.gripperOpen, Config.gripperClosed, Config.gripperOpen);
        wrist = new ServoClass(opMode.hardwareMap.get(Servo.class, Config.wristServo), Config.wristVertical, Config.wristHorizontal, Config.wristHorizontal);

        // Other
        voltageHandler = new VoltageHandler(opMode);
        imu = new BotIMU(opMode);
        led = new LEDController(opMode);

        // Commands
        commands = new Commands(this);
    }
}
