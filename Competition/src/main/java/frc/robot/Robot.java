// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.routines.Routine1BLeftS;
import frc.robot.commands.routines.Routine1BRightS;
import frc.robot.commands.routines.Routine2B;
import frc.robot.commands.routines.Routine2BMean;
import frc.robot.commands.routines.Routine3BF;
import frc.robot.commands.routines.Routine3BS;
import frc.robot.commands.routines.Routine4BF;
import frc.robot.commands.routines.Routine4BS;
import frc.robot.commands.routines.ShootTest;
//import frc.robot.commands.routines.RoutineHigh2B;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private final Command routine1leftslow = new Routine1BLeftS();
    private final Command routine1rightslow = new Routine1BRightS();


    private final Command routine2 = new Routine2B();
    private final Command routine3slow = new Routine3BS();
    private final Command routine2mean = new Routine2BMean();
    private final Command routine4slow= new Routine4BS();
    //private final Command routine2high = new Routine2BF();
    private final Command routine3fast = new Routine3BF();
    private final Command routine4fast = new Routine4BF();
    private final Command shootroutine = new ShootTest();
    //private final Command routine5high = new Routine5BF();

    
    static SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //m_chooser.setDefaultOption("Routine 1 Left", routine1leftslow);
    //m_chooser.addOption("Routine 1 Right", routine1rightslow);
    //m_chooser.addOption("Routine 2", routine2);
    //m_chooser.addOption("Routine 3 slow", routine3slow);
    //m_chooser.addOption("Routine 2 Mean", routine2mean);
    //m_chooser.addOption("Routine 4 slow", routine4slow);
    //m_chooser.addOption("Routine 2 High", routine2high);
    //m_chooser.addOption("Routine 3 fast", routine3fast);
    //m_chooser.addOption("Routine 4 fast", routine4fast);
    m_chooser.addOption("Shoot Routine", shootroutine);



    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    
    SmartDashboard.putData(m_chooser);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    RobotContainer.driveSubsystem.reset( new Pose2d( 0, 0, new Rotation2d( 0 )));
  }

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    RobotContainer.driveCommand.schedule();
    RobotContainer.bodyCommand.schedule();

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
