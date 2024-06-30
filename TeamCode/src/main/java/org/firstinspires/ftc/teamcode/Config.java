package org.firstinspires.ftc.teamcode;


/**
 * This class is used to store all of the constants and hardware map names for the robot
 */
public class Config {
    // ---- Constants ----
    // Odometer constants
    public static final double wheelDiameter = 4.8;
    public static final double ticsPerRev = 2000;
    public static final double ticsToCM = (wheelDiameter * Math.PI) / ticsPerRev;
    public static final double trackWidth = 26.5; //In CM
    public static final double forwardOffset = Math.sqrt((15.5*15.5)-0.4); //In CM
    //These are the ticks travelled by each odometer after 20 rotations
    //Used in place of radius between center of rotation and each odometer
    public static final double center20FullRotationOdosInTicksDiv40pi = 238278 / (40 * Math.PI);
    public static final double left20FullRotationOdosInTicksDiv40pi = 238269 / (40 * Math.PI);
    public static final double right20FullRotationOdosInTicksDiv40pi = 206129 / (40 * Math.PI);

    // PID constants
    public static final double[] drivePID = {0.1, 0.001, 1}; // kP, kI, kD
    public static final double[] turnPID = {0.1, 0.001, 1}; // kP, kI, kD

    // ---- Hardware Map ----
    // Odometers
    public static final String odoLeft = "OdoLeft";
    public static final String odoCenter = "hang";
    public static final String odoRight = "collector";

    // Drive motor names
    public static final String motorLF = "LF";
    public static final String motorLB = "LB";
    public static final String motorRF = "RF";
    public static final String motorRB = "RB";

    // Servo names


    // Motor names
    public static final String slideMotor = "slideArm";

    // Other names
    public static final String led = "led";
    public static final String imu = "expansionIMU";
}
