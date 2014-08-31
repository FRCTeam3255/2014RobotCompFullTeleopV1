package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


//import edu.wpi.first.wpilibj.templates.commands.DoDriveDistance;
/**
 *
 * @author Super NURDs
 */
public class CatapultReleaseAndReturnLatch extends CommandGroup {

    public CatapultReleaseAndReturnLatch() {
        addSequential(new CatapultReleaseLatch());
        addSequential(new DoDelay(0.3));
        addSequential(new CatapultReturnLatch());
    }
}