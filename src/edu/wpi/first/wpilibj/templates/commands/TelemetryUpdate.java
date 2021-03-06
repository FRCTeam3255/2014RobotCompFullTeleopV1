package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class TelemetryUpdate extends CommandBase {

    public TelemetryUpdate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(telemetry);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        telemetry.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        telemetry.update();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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