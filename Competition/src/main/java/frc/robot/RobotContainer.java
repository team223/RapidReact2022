// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.BodyCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveVeloc;
import frc.robot.commands.routines.*;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static DriveSubsystem driveSubsystem = new DriveSubsystem(); 

  public static IndexSubsystem indexSubsystem = new IndexSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();

  
  public static Command driveCommand = new DriveCommand();
  public static Command bodyCommand = new BodyCommand();
  
  public static Joystick joystick1 = new Joystick(0);
  public static Joystick joystick2 = new Joystick(1);


    // A simple auto routine that drives forward a specified distance, and then stops.
    

// A complex auto routine that drives forward, drops a hatch, and then drives backward.

// A chooser for autonomous commands


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    System.out.println( "test" );
    

// Put the chooser on the dashboard

    // An ExampleCommand will run in autonomous
    return Robot.m_chooser.getSelected();
  }
}
