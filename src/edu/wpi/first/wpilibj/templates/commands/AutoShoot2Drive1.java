package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author Super NURDs
 */

public class AutoShoot2Drive1 extends CommandGroup {

    public AutoShoot2Drive1() {
        addSequential(new IntakePositionDeploy());
        addParallel(new AutoIntakeRollerForward());
        addSequential(new AutoDriveDistancePID(2.5));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new CatapultWindLimitSwitch());
        addParallel(new CatapultUnwindEncoder());
        addSequential(new IntakePositionRetract());
        addSequential(new DoDelay(0.5));
        addSequential(new IntakePositionDeploy());
        addSequential(new DoDelay(2.0));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new AutoDriveDistancePID(4.0));
    }
}