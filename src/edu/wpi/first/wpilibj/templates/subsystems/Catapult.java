/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Super NURDs
 *
 */
public class Catapult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //Doubles and booleans
    public double catapultWinchWindSpeed = 0.0;
    public double catapultWinchEncoderValue = 0.0;
    public boolean catapultLatchSolenoidState = true; //true is held and false is relased
    public boolean catapultLatchSwitchState = true; //true is open and false is closed
    //Motor controllers
    Talon catapultTalon = null;
    //Solenoids
    DoubleSolenoid catapultSolenoid = null;
    //Sensors
    Encoder catapultEncoder = null;
    LimitSwitch catapultSwitch = null;
    
    public Catapult() {
        try {
            catapultTalon = new Talon(RobotMap.CATAPULT_TALON);
            catapultTalon.setSafetyEnabled(false);

            catapultSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_SLOT_1, RobotMap.CATAPULT_LATCH_OPEN_SOLENOID, RobotMap.CATAPULT_LATCH_CLOSE_SOLENOID);

            catapultEncoder = new Encoder(RobotMap.CATAPULT_WINCH_ENCODER_CH_A, RobotMap.CATAPULT_WINCH_ENCODER_CH_B);

            catapultEncoder.setDistancePerPulse(RobotMap.CATAPULT_ENCODER_A_ROTATIONS_PER_PULSE);

            catapultSwitch = new LimitSwitch(RobotMap.CATAPULT_LIMIT_SWITCH_CHANNEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //None currently
    }

    public void setCatapultWindSpeed(double s) {
        // Allows us to set the speed of the motor winding the catapult
        try {
            catapultTalon.set(s);
            catapultWinchWindSpeed = s;
        } catch (Exception e) {    
        }
    }

    public void windCatapultForward() {
        // Uses setCatapultWindSpeed to spin to wind, in this case -1
        setCatapultWindSpeed(-1.0);
    }

    public void windCatapultWindReverse() {
        // Uses setCatapultWindSpeed to spin to unwind, in this case 1
        setCatapultWindSpeed(1.0);
    }

    public void windCatapultWindStop() {
        // Stops setCatapultStop at 0.0
        setCatapultWindSpeed(0.0);
    }

    public void returnLatch() {
        // Used to hold the latch for the Catapult in place
        try {
            catapultSolenoid.set(DoubleSolenoid.Value.kForward);
            catapultLatchSolenoidState = true;
        } catch (Exception e) {
        }
    }

    public void releaseLatch() {
        // Used to release the Catapult, also technically the fire command  
        try {
            catapultSolenoid.set(DoubleSolenoid.Value.kReverse);
            catapultLatchSolenoidState = false;
        } catch (Exception e) {
        }
    }

    public boolean getCatapultSwitchState() {
        boolean openState = catapultSwitch.isOpen();
        catapultLatchSwitchState = openState;
        return catapultSwitch.isOpen();
    }
    
    // Retrives the number from the encoder after starting it
    // Encoder vaule returned in units of rotations, so 1.0 = 1 rotation
    public double getCatapultEncoderValue() {
        if (catapultEncoder == null) {
            return (0.0);
        }
        double encValue = catapultEncoder.getDistance();
        catapultWinchEncoderValue = encValue;
        return (encValue);
    }

    public void startCatapultEncoder() {
        // Starts the encoder so we can use it
        try {
            catapultEncoder.start();
        } catch (Exception e) {
        }
    }

    public void stopCatapultEncoder() {
        // Stops the encoder when we are not using it
        try {
            catapultEncoder.stop();
        } catch (Exception e) {
        }
    }

    public void resetCatapultEncoder() {
        // Resets the encoder, we use this before we use it everytime       
        try {
            catapultEncoder.reset();
        } catch (Exception e) {
        }
    }
    
    public void catapultEncoderInit() {
        startCatapultEncoder();
        resetCatapultEncoder();
    }
    
    public boolean catapultLatchState() {
        // Tells us the current position of the gearing
        return catapultLatchSolenoidState;
    }
    
    public double catapultWindSpeed() {
        return catapultWinchWindSpeed;
    }

    /**
     * Get the number of rotations that would properly unwind the catapult
     * @return 
     */
    public double getUnwindRotations() {
        return (2 * DriverStation.getInstance().getAnalogIn(1));
    }
    
    public double catapultEncoderValue() {
        return catapultWinchEncoderValue;
    }

    public boolean catapultSwitchState() {
        return catapultLatchSwitchState;
    }
}