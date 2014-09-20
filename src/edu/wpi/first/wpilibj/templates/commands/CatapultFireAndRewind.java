package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Super NURDs
 */
public class CatapultFireAndRewind extends CommandGroup {

    public CatapultFireAndRewind() {
        addSequential(new CatapultReleaseAndReturnLatch());
        addSequential(new DoDelay(1.0));
        addSequential(new CatapultWindAndUnwind());
    }
}