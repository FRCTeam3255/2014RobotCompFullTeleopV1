package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class CatapultWindWinchReverse extends CommandBase {

    public CatapultWindWinchReverse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         catapult.windCatapultWindReverse();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Returns true so that this ends after being called
        return true;
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