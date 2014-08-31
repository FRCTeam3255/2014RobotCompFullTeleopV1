/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Super NURDs
 *
 */
public class IntakeRoller extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands

    //Doubles and Booleons
    public double intakeRollerSpeed = 0.0;
    
    //Motor controllers
    Talon intakeTalon = null;
    
    public IntakeRoller() {
        try {
            intakeTalon = new Talon(RobotMap.INTAKE_TALON);
            intakeTalon.setSafetyEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // In this case none, for now
    }

    public void setIntakeRollerSpeed(double s) {
        // Allows us to set the speed of the motor that runs the intake roller
        try {
            intakeTalon.set(s);
            intakeRollerSpeed = s;
        } catch (Exception e) {
        }
    }

    public void intakeRollerForward() {
        // Run the intake motor forward at full speed forward, in this case 1
        setIntakeRollerSpeed(-1.0);
    }

    public void intakeRollerReverse() {
        // Run the intake motor at full speed in reverse, in this case -1
        setIntakeRollerSpeed(1.0);
    }

    public void intakeRollerStop() {
        // Stop the intake motor at 0.0
        setIntakeRollerSpeed(0.0);
    }
    
     public double intakeRollerSpeed() {
        return intakeRollerSpeed;
     }

}