// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;

public class WarmUp extends WaitFor {
  /** Creates a new ShootFor. */
  private double SSpeed;
  private double RSpeed;
  private int shooterCounter;

  public WarmUp( double time, double SSpeed, double RSpeed ) {
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
  }

   // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterCounter = 0;
  
}}
