package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


//import edu.wpi.first.wpilibj.templates.commands.DoDriveDistance;
/**
 *
 * @author Super NURDs
 */



public class CatapultWindAndUnwind extends CommandGroup {

    public CatapultWindAndUnwind() {
        addSequential(new CatapultWindLimitSwitch());
        addSequential(new DoDelay(0.2));
        addSequential(new CatapultUnwindEncoder());
    }
}