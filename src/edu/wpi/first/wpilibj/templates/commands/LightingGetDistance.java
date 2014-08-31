/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Super NURDs
 */
public class LightingGetDistance extends CommandBase {

    public LightingGetDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        requires(lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       double d = vision.getDistance();
       
       if((d >= RobotMap.SHOOT_DISTANCE_MIN) && (d <= RobotMap.SHOOT_DISTANCE_MAX)) {
           // Turn lights on
           lighting.setCyanValue(true);
       }
       else {
           // Turn lights off
           lighting.setCyanValue(false);
       }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}