package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    // cRIO Slots
    public static final int ANALOG_SLOT = 1;
    public static final int DIGITAL_SIDECAR_SLOT = 2;
    public static final int SOLENOID_SLOT_1 = 1;
    
    // Analog Input
    public static final int DRIVE_GYROSCOPE = 1;
    
    // Digital I/O
    public static final int DRIVE_RIGHT_ENCODER_CH_A = 1;
    public static final int DRIVE_RIGHT_ENCODER_CH_B = 2;
    public static final int DRIVE_LEFT_ENCODER_CH_A = 3;
    public static final int DRIVE_LEFT_ENCODER_CH_B = 4;
    public static final int CATAPULT_WINCH_ENCODER_CH_A = 5;
    public static final int CATAPULT_WINCH_ENCODER_CH_B = 6;
    public static final int PNEUMATICS_PRESSURE_SWITCH_CHANNEL = 7;
    public static final int CATAPULT_LIMIT_SWITCH_CHANNEL = 8;
    // DI/O 9 free
    // DI/O 10 free
    // DI/O 11 free
    // DI/O 12 free
    public static final int LIGHT_SENSOR_CHANNEL_1 = 13;
    
    // PWM Out
    public static final int DRIVE_RIGHT_FRONT_TALON = 1;
    public static final int DRIVE_RIGHT_BACK_TALON = 2;
    public static final int DRIVE_LEFT_FRONT_TALON = 3;
    public static final int DRIVE_LEFT_BACK_TALON = 4;
    public static final int INTAKE_TALON = 5;
    public static final int CATAPULT_TALON = 6;
    // Out 7 free
    // Out 8 free
    // Out 9 free
    // Out 10 free
    
     // I2C Slaves
    public static final int DRIVE_ACCELEROMETER = 1;
    
    // Relays
    public static final int PNEUMATICS_COMPRESSOR_RELAY = 1;
    public static final int LIGHTING_RED_RELAY = 2;
    public static final int LIGHTING_BLUE_RELAY = 3;
    public static final int LIGHTING_GREEN_RELAY = 4;
    public static final int LIGHTING_CYAN_RELAY = 5;
    public static final int LIGHTING_CHOCOLATE_RELAY = 6;
    public static final int LIGHTING_YELLOW_RELAY = 7;
    public static final int LIGHTING_BLACK_RELAY = 8;
    
    // Solenoid Relays on slot 1
    public static final int DRIVE_SHIFT_OPEN_SOLENOID = 1;
    public static final int DRIVE_SHIFT_CLOSE_SOLENOID = 2;
    public static final int CATAPULT_LATCH_OPEN_SOLENOID = 3;
    public static final int CATAPULT_LATCH_CLOSE_SOLENOID = 4;
    public static final int INTAKE_POSITION_OPEN_SOLENOID = 5;
    public static final int INTAKE_POSITION_CLOSE_SOLENOID = 6;
    public static final int STINGER_SOLENOID = 7;
    
    // Controller Inputs
    public static final int DRIVER_HID = 1;
    public static final int MANIPULATOR_HID = 2;
    
    // Variables
    // The wheel is a 4 in diameter
    // Therefore, distance travelled/wheel rot:
    //      (4 in * PI)
    //      -----------
    //      wheel rot
    // For every one wheel rotation we get one rotation of the 64 tooth gear (A)
    // For every 64 teeth on gear (A) we get 20 teeth on gear (B), for one gear (B) rotation
    
    // For every gear (B) rotation we get one rotation of the 36 tooth gear (C)
    // For every 36 teeth on gear (C) we get 12 teeth on gear (D), for one gear (D) rotation
    
    // For every one rotation of gear (D) we get one encoder rotation
    // For every encoder rotation, we get 250 pulses
    
    
    // To compute ft / encoder pulse:
    
    // (4.125 * PI) in    1 ft     1 A rot     20 teeth    1 B rot     1 C rot    12 teeth     1 encoder rot
    //   ------------- * ------ * ---------- * -------- * --------- * --------- * --------- * --------------
    //     1 wheel rot    12 in    64 teeth    1 B rot     1 C rot    36 teeth     1 D rot      250 pulses
    //
    // Result = 0.0004363323129
    public static final double DRIVE_ENCODER_FEET_PER_PULSE = (57.0 / 48.0) * (4.125 * Math.PI) * (1.0 / 12.0) * (1.0 / 64.0) * (20.0 / 1.0) * (1.0 / 36.0) * (12.0 / 1.0) * (1.0 / 250.0);
    
    //public static final double DRIVE_ENCODER_INCHES_PER_PULSE = (4.5 * Math.PI) * (1.0 / 250.0);
    
    // For every one rotation of gear (A) there are 60 teeth
    // For every one rotation of gear (B) there are 24 teeth
    // For every one rotation of (B) there is one encoder rotation
    // For every one encoder rotation there are 250 pulses
    
    //   1 A rot     60 teeth      1 B rot      1 encoder rot 
    // ----------- * -------- * ------------- * --------------
    //  24 teeth      1 B rot   1 encoder rot     250 pulses  
    
    
    
    public static final double CATAPULT_ENCODER_A_ROTATIONS_PER_PULSE = (1.0 / 60.0) * (24.0 / 1.0) * (1.0 / 250.0);
    
    // Catapult Variables
    public static final double CATAPULT_WINCH_WIND_SPEED = -1.0;
    public static final double CATAPULT_WINCH_UNWIND_SPEED = 1.0;
    public static final double CATAPULT_WINCH_UNWIND_ROTATIONS = 6.0;
        
    public static final double SHOOT_DISTANCE_MIN = 8;
            
    public static final double SHOOT_DISTANCE_MAX = 14;
}