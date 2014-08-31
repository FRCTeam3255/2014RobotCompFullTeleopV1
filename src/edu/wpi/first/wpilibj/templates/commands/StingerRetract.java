package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class StingerRetract extends CommandBase {

    public StingerRetract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(stinger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // None currently
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Sets the state of the Stinger solenoid to retract the Stinger
        stinger.retractStinger();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Retruns true so this state is only set once per time called
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