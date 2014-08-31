package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author Super NURDs
 */

public class AutoShoot2Drive extends CommandGroup {

    public AutoShoot2Drive() {
        addSequential(new IntakePositionDeploy());
        addSequential(new DoDelay(1.2));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new CatapultWindLimitSwitch());
        addParallel(new CatapultUnwindEncoder());
        addSequential(new AutoIntakeRollerForward());
        addSequential(new IntakePositionRetract());
        addSequential(new DoDelay(1.0));
        addSequential(new IntakePositionDeploy());
        addSequential(new DoDelay(1.5));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new AutoDriveDistancePID(7.0));
    }
}