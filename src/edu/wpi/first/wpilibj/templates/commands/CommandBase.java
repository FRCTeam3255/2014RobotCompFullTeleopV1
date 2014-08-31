package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.subsystems.Catapult;
import edu.wpi.first.wpilibj.templates.subsystems.IntakeRoller;
import edu.wpi.first.wpilibj.templates.subsystems.IntakePosition;
import edu.wpi.first.wpilibj.templates.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.templates.subsystems.Telemetry;
import edu.wpi.first.wpilibj.templates.subsystems.Stinger;
import edu.wpi.first.wpilibj.templates.subsystems.Vision;
import edu.wpi.first.wpilibj.templates.subsystems.Lighting;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Super NURDs
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    // Create a single static instance of all of your subsystems
    public static Drivetrain drivetrain = new Drivetrain();
    public static Catapult catapult = new Catapult();
    public static IntakeRoller intakeRoller = new IntakeRoller();
    public static IntakePosition intakePosition = new IntakePosition();
    public static Pneumatics pneumatics = new Pneumatics();
    public static Telemetry telemetry = new Telemetry();
    public static Vision vision = new Vision();
    public static Stinger stinger = new Stinger();
    public static Lighting lighting = new Lighting();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}