/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Super NURDs
 *
 */
public class IntakePosition extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands

    //Doubles and Booleons
    public boolean intakePosition = false;    
    //Solenoids
    DoubleSolenoid intakeSolenoid = null;

    public IntakePosition() {
        try {
            intakeSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_SLOT_1, RobotMap.INTAKE_POSITION_OPEN_SOLENOID, RobotMap.INTAKE_POSITION_CLOSE_SOLENOID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // In this case none, for now
    }

    public void deployIntake() {
        // Deploys the intake by setting the intake solenoid to open
        try {
            intakeSolenoid.set(DoubleSolenoid.Value.kForward);
            intakePosition = true;
        } catch (Exception e) {
        }
    }

    public void retractIntake() {
        // Retracts the intake by settubg the intake solenoid to close 
        try {
            intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
            intakePosition = false;
        } catch (Exception e) {
        }
    }

    public boolean intakePosition() {
        // Tells us the current position of the gearing
        return intakePosition;
    }

}