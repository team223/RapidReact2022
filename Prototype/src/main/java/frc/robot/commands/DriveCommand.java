/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  /**
   * Creates a new DriveCommand.
   */
  public DriveCommand() {
    addRequirements( RobotContainer.driveSubsystem );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   // RobotContainer.driveSubsystem.PIDTest( true );
    RobotContainer.driveSubsystem.cheezyDrive(RobotContainer.joystick1.getRawAxis( 1 ), RobotContainer.joystick1.getRawAxis( 4 ));
    /*
    SmartDashboard.putNumber( "kP", SmartDashboard.getNumber( "kP", RobotContainer.drivetrainKP ));
    RobotContainer.drivetrainKP = SmartDashboard.getNumber( "kP", RobotContainer.drivetrainKP );
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
