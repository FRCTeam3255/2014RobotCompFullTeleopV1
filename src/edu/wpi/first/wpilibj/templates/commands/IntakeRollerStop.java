package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author SuperNURD
 */
public class IntakeRollerStop extends CommandBase {

    public IntakeRollerStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeRoller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // None currently
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Turns the intake motor to speed 0.0
        intakeRoller.intakeRollerStop();
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