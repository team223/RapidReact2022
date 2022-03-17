// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveClimbers extends CommandBase {
  /** Creates a new DriveClimbersFor. */
  private double position; 
  private boolean driveUp = false;

  public DriveClimbers( double position ) {
    this.position = position;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if( RobotContainer.climberSubsystem.getLPosition() < position ){
      System.out.println( "drive Up " );
      driveUp = true;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
  
      if( driveUp ){
        RobotContainer.climberSubsystem.setClimbers( -1 );
      }else{
        RobotContainer.climberSubsystem.setClimbers( 1 );
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if( RobotContainer.climberSubsystem.getLPosition() <= 0 && !driveUp ){
      return true;
    }

    if( driveUp ){
      return RobotContainer.climberSubsystem.getLPosition() >= position;

    }else{
      return RobotContainer.climberSubsystem.getLPosition() <= position;
    }
  }
}
