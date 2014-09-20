package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class CatapultWindWinchForward extends CommandBase {

    public CatapultWindWinchForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        catapult.windCatapultForward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // getCatapultSwitchState returns false when closed
        if (catapult.getCatapultSwitchState() == false) {
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        catapult.windCatapultWindStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // Failsafe
        end();
    }
}