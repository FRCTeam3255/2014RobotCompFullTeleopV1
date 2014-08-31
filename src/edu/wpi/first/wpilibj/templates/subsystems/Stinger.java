/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 *
 * @author Super NURDs
 *
 */
public class Stinger extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //Doubles and booleans
    public boolean stingerDeployState;
    
    //Solenoids
    Solenoid stingerSolenoid = null;

    public Stinger() {
        try {
            stingerSolenoid = new Solenoid(RobotMap.SOLENOID_SLOT_1, RobotMap.STINGER_SOLENOID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        this.setDefaultCommand(new StingerRetract());
    }

    public void deployStinger() {
        // Deploy the stinger to change the shooter angle by setting the stinger solenoid to open
        try {
            stingerSolenoid.set(true);
            stingerDeployState = true;
        } catch (Exception e) {
        }
    }

    public void retractStinger() {
        // Retract the stinger to change the shooter angle by setting the stinger solenoid to close
        try {
            stingerSolenoid.set(false);
            stingerDeployState = false;
        } catch (Exception e) {
        }
    }
    
     public boolean stingerDeployState() {
        // Tells us the current position of the gearing
        return stingerDeployState;
    }
}