// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Initialize extends WaitFor {
  /** Creates a new Initialize. */
  private Pose2d initialPose;
  
  public Initialize( Pose2d pose2d ) {
    super( 0.1 );
    addRequirements(RobotContainer.driveSubsystem);

    initialPose = pose2d;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    super.initialize();
    RobotContainer.driveSubsystem.reset( initialPose );
  }
}
