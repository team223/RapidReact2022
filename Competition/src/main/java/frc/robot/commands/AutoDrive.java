// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;

public class AutoDrive extends WaitFor {
  private double leftSpeed;
  private double rightSpeed;

  /** Creates a new ShootFor. */

  public AutoDrive( double time, double leftSpeed, double rightSpeed) {
    super( time );
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    addRequirements( RobotContainer.indexSubsystem, RobotContainer.shooterSubsystem );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    super.execute();
    RobotContainer.driveSubsystem.setMotors(leftSpeed, rightSpeed);
  }

   // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.setMotors( 0, 0 );
    

  
}}
