package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class IntakePositionRetract extends CommandBase {

    public IntakePositionRetract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakePosition);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // None currently
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Set the state of the Intake solenoid to retract the Intake
        intakePosition.retractIntake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Returns true so that this only runs once per time called
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        // None currently
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // fail/safe
        end();
    }
}