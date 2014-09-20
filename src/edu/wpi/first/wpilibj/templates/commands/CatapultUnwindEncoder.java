package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 *
 * @author Super NURDs
 */
public class CatapultUnwindEncoder extends CommandBase {

    double rotations;
    
    /**
     * Rotate the catapult the number of rotations specified by r
     */
    public CatapultUnwindEncoder() {
        requires(catapult);
    }

    // Called just before this Command runs the first time
    /**
     * Set the setpoint to the stored value and enable PID on the catapult.
     */
    protected void initialize() {
        // initialize the encoders (reset to 0)
        catapult.catapultEncoderInit();
        
        // determine how many rotations to perform
        this.rotations = catapult.getUnwindRotations();
        
        // start unwinding
        catapult.windCatapultWindReverse();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the distance
     */
    protected boolean isFinished() {
        // if the encoder has turned more than the number of rotations needed,
        // we are finished
        if (catapult.getCatapultEncoderValue() >= rotations) {
            return true;
        }
        return (false);
    }

    // Called once after isFinished returns true
    protected void end() {
        catapult.windCatapultWindStop();
        catapult.stopCatapultEncoder();
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