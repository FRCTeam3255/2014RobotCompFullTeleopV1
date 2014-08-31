package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author Super NURDs
 */

public class AutoShoot3 extends CommandGroup {

    public AutoShoot3() {
        addSequential(new IntakePositionDeploy());
        addSequential(new DoDelay(0.3));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new CatapultWindLimitSwitch());
        addParallel(new CatapultUnwindEncoder());
        addSequential(new AutoIntakeRollerForward());
        addSequential(new IntakePositionRetract());
        addSequential(new DoDelay(1.0));
        addSequential(new IntakePositionDeploy());
        addSequential(new DoDelay(1.0));
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new CatapultWindLimitSwitch());
        addParallel(new CatapultUnwindEncoder());
        addSequential(new AutoDriveDistancePID(-2.0));
        addSequential(new AutoIntakeRollerForward());
        addParallel(new IntakePositionRetract());
        addSequential(new AutoDriveDistancePID(2.0));
        addParallel(new IntakePositionDeploy());
        addSequential(new DoDelay(1.0));
        addSequential(new CatapultReleaseAndReturnLatch());
    }
}