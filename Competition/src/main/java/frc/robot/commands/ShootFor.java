// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;

public class ShootFor extends WaitFor {
  /** Creates a new ShootFor. */
  private double SSpeed;
  private double RSpeed;
  private int shooterCounter;

  public ShootFor( double time, double SSpeed, double RSpeed ) {
    super( time );
    this.SSpeed = SSpeed;
    this.RSpeed = RSpeed;

    addRequirements( RobotContainer.indexSubsystem, RobotContainer.shooterSubsystem );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    super.execute();
    RobotContainer.shooterSubsystem.setShooterSpeed( SSpeed );
    RobotContainer.shooterSubsystem.setRoller( RSpeed);
    System.out.println( "running" );
    if( shooterCounter>30 ){
      RobotContainer.indexSubsystem.setFeeder( 0.75 );
    }
    else{RobotContainer.indexSubsystem.setFeeder(0);     shooterCounter++;
    }
  }

   // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooterSubsystem.setShooter( 0 );
    shooterCounter = 0;
    RobotContainer.indexSubsystem.setFeeder( 0 );  }
  
}
