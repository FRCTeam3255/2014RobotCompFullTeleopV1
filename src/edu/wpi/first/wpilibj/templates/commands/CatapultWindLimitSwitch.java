package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 *
 * @author Super NURDs
 */


public class CatapultWindLimitSwitch extends CommandBase {

    private final double m_timeout;
    double speed;
    
    /**
     * Rotate the catapult the number of rotations specified by r
     */
    public CatapultWindLimitSwitch() {
        this.m_timeout = 4.5;
        requires(catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(m_timeout);
        catapult.windCatapultForward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the distance
     */
    protected boolean isFinished() {
       if(isTimedOut()) {
           return true;
        }
        
        // getCapultSwitchState return false when closed
        if (catapult.getCatapultSwitchState() == false) {
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    /**
     * When this command ends, disable the catapult's PID
     */
    protected void end() {
        catapult.windCatapultWindStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * When this command exits, disable the catapult's PID
     */
    protected void interrupted() {
        end();
    }
}