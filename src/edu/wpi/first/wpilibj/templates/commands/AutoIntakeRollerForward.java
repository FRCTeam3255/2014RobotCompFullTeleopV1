package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class AutoIntakeRollerForward extends CommandBase {

    public AutoIntakeRollerForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeRoller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Runs the Intake motor forward to pick up a ball, in this case a speed of 1
        intakeRoller.intakeRollerForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Returns true so that the command ends when it stops being called
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        intakeRoller.intakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // Failsafe
        end();
    }
}