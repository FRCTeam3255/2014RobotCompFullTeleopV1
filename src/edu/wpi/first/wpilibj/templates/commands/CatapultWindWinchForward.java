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
        // None currently
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // A method from Catapult that winds the catapult to prepare to shoot
        if (!catapult.getCatapultSwitchState()) {
            catapult.windCatapultForward();
        }
        else {
            catapult.windCatapultWindStop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        // None currently
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // Failsafe
        end();
    }
}