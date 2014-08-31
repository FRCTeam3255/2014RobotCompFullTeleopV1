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
    /**
     * Set the setpoint to the stored value and enable PID on the catapult.
     */
    protected void initialize() {
        setTimeout(m_timeout);
        if (catapult.getCatapultSwitchState()) {
            this.speed = RobotMap.CATAPULT_WINCH_WIND_SPEED;
        }
        else {
            this.speed = 0.0;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.setCatapultWindSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the distance
     */
    protected boolean isFinished() {
        if (!isTimedOut()) {
            if (catapult.getCatapultSwitchState() == false) {
            return (true);
            } else {
                return (false);
            }
        } else {
            return isTimedOut();
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