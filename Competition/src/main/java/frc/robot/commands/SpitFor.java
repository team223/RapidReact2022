// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SpitFor extends WaitFor {
  /** Creates a new SpitFor. */
   public SpitFor( double executesFor ) {
    super( executesFor );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.intakeSubsystem.setIntake( 1 );
  }
     
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.indexSubsystem.setFeeder( 0 );
  }

}
