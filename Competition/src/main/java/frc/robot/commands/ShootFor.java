// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;

public class ShootFor extends WaitFor {
  /** Creates a new ShootFor. */
  private double speed;

  public ShootFor( double time, double speed ) {
    super( time );
    this.speed = speed;

    addRequirements( RobotContainer.indexSubsystem, RobotContainer.shooterSubsystem );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    RobotContainer.shooterSubsystem.setShooterSpeed( speed );

    if( Math.abs( RobotContainer.shooterSubsystem.getSpeed() - speed ) < 100 ){
      RobotContainer.indexSubsystem.setGateway( 0.25 );
      RobotContainer.indexSubsystem.setFeeder( 0.25 );
    }
  }  
}