package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.command.CommandGroup;


//import edu.wpi.first.wpilibj.templates.commands.DoDriveDistance;
/**
 *
 * @author Super NURDs
 */



public class AutoShoot3Drive extends CommandGroup {

    public AutoShoot3Drive() {
        addParallel(new PneumaticsCompressorRun());
        boolean hot = CommandBase.vision.isTargetHot();
        CommandBase.vision.writeImages("_hot_");
        if (hot == false) {
            addParallel(new DoDelay(5.0));
        }
        addSequential(new CatapultReleaseLatch());
        addSequential(new DoDelay(0.5));
        addSequential(new AutoDriveDistance(4.0));
    }
}