package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 *
 * @author Super NURDs
 */
public class AutoDriveDistance extends CommandBase {

    double speed;
    double distance;
    boolean forward;
    private static final double FIXED_SPEED = 0.80;

    /**
     * Drive the specified distance (in feet) at the specified speed (0->1)
     * @param d
     */
    public AutoDriveDistance(double d) {
        requires(drivetrain);
        if (d > 0) {
            this.distance = d;
            forward = true;
            this.speed = FIXED_SPEED;
        } else {
            this.distance = d;
            forward = false;
            this.speed = -FIXED_SPEED;
        }
    }

    // Called just before this Command runs the first time
    /**
     * Set the setpoint to the stored value and enable PID on the drivetrain.
     */
    protected void initialize() {
        drivetrain.driveEncodersInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.arcadeDrive(speed, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the distance
     */
    protected boolean isFinished() {
        if (forward) {
            if ((distance - drivetrain.getLeftEncoderValue() + drivetrain.getRightEncoderValue()) / 2 >= 0) {
                return (true);
            }
        } else {
            if ((distance - drivetrain.getLeftEncoderValue() + drivetrain.getRightEncoderValue()) / 2 <= 0) {
                return (true);
            }
        }
        return (false);
    }

    // Called once after isFinished returns true
    /**
     * When this command ends, disable the drivetrain's PID
     */
    protected void end() {
        drivetrain.arcadeDrive(0.0, 0.0);
        drivetrain.stopEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * When this command exits, disable the drivetrain's PID
     */
    protected void interrupted() {
        end();
    }
}