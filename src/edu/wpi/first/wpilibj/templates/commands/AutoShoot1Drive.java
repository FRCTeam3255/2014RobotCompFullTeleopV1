package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author SuperNURDs
 */

public class AutoShoot1Drive extends CommandGroup {

    public AutoShoot1Drive() {
        addSequential(new AutoDriveDistance(7.0));
        addSequential(new IntakePositionDeploy());
        addSequential(new AutoVisionDelay());
        addSequential(new CatapultReleaseAndReturnLatch());
    }
}