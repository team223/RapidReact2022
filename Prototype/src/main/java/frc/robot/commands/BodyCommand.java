/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class BodyCommand extends CommandBase {
  /**
   * Creates a new BodyCommand.
   */
  public BodyCommand() {
    addRequirements( RobotContainer.indexSubsystem, RobotContainer.shooterSubsystem
    , RobotContainer.indexSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if( RobotContainer.joystick1.getRawButton( 0 ) ){
      RobotContainer.indexSubsystem.setRollers(0.5);
    }

    if( RobotContainer.joystick1.getRawButton( 1 )){
      RobotContainer.indexSubsystem.setTower(0.5);
    }

    if( RobotContainer.joystick1.getRawButton( 2 ) ){
      RobotContainer.intakeSubsystem.setIntake( 0.5 );
    }

    RobotContainer.shooterSubsystem.setShooter( RobotContainer.joystick1.getRawAxis(2) );
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
