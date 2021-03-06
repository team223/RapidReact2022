// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;

public class ShootFor extends WaitFor {
  /** Creates a new ShootFor. */
  private double SSpeed;
  private double RSpeed;
  private int shooterCounter = 0;

  public ShootFor( double time, double SSpeed, double RSpeed ) {
    super( time );
    this.SSpeed = SSpeed;
    this.RSpeed = RSpeed;
    shooterCounter = 0;
    addRequirements( RobotContainer.indexSubsystem, RobotContainer.shooterSubsystem );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println( "counter: " + shooterCounter );
    super.execute();
    RobotContainer.shooterSubsystem.setShooterSpeed( SSpeed );
    RobotContainer.shooterSubsystem.setRoller( RSpeed);
    
    if( shooterCounter>45 ){
      RobotContainer.indexSubsystem.setFeeder( 0.75 );
    }else if( shooterCounter < 6 ){
      shooterCounter++;
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
    System.out.println( "end!" );
    RobotContainer.indexSubsystem.setFeeder( 0 );

  
}}
