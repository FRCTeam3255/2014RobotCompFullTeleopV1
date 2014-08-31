package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 *
 * @author Super NURDs
 */
public class CatapultUnwindEncoder extends CommandBase {

    double speed;
    double rotations;
    
    /**
     * Rotate the catapult the number of rotations specified by r
     */
    public CatapultUnwindEncoder() {
        requires(catapult);
    }

    // Called just before this Command runs the first time
    /**
     * Set the setpoint to the stored value and enable PID on the catapult.
     */
    protected void initialize() {
        this.speed = RobotMap.CATAPULT_WINCH_UNWIND_SPEED;
//        this.rotations = RobotMap.CATAPULT_WINCH_UNWIND_ROTATIONS;
        this.rotations = 2 * DriverStation.getInstance().getAnalogIn(1);
        
        catapult.catapultEncoderInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.setCatapultWindSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return true when it's close enough to the distance
     */
    protected boolean isFinished() {
        if ((rotations - catapult.getCatapultEncoderValue()) <= 0) {
                return (true);
        }
        return (false);
    }

    // Called once after isFinished returns true
    /**
     * When this command ends, disable the catapult's PID
     */
    protected void end() {
        catapult.windCatapultWindStop();
        catapult.stopCatapultEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * When this command exits, disable the catapult's PID
     */
    protected void interrupted() {
        end();
    }
}