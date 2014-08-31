package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Super NURDs
 */
public class StingerDeploy extends CommandBase {

    public StingerDeploy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(stinger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //does nothing
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //deploys solenoid, extends stinger
        stinger.deployStinger();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //returns true and leaves stinger to deploy
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        //none currently
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //failsafe
        end();
    }
}