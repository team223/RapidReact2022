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
    addRequirements( RobotContainer.shooterSubsystem
    , RobotContainer.indexSubsystem, RobotContainer.intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if( RobotContainer.joystick1.getRawButton( 1 ) ){
      RobotContainer.shooterSubsystem.setShooter(.3);
    } else if( RobotContainer.joystick1.getRawButton( 2 )){
      RobotContainer.shooterSubsystem.setShooter(.5);
    }else if( RobotContainer.joystick1.getRawButton( 3 ) ){
      RobotContainer.shooterSubsystem.setShooter(.75);
    }else if( RobotContainer.joystick1.getRawButton( 4 ) ){
      RobotContainer.shooterSubsystem.setShooter(1);
    }else{
      RobotContainer.shooterSubsystem.setShooter(0);
    }

    if( RobotContainer.joystick1.getRawButton(6 ) ){
      RobotContainer.indexSubsystem.setTower( .5 );
    }else{
      RobotContainer.indexSubsystem.setTower( 0 );
    }

    if( RobotContainer.joystick1.getRawButton( 5 ) ){
      RobotContainer.intakeSubsystem.setIntake( 0.75 );
      RobotContainer.indexSubsystem.setRollers( 0.5 );
    }else{
      RobotContainer.intakeSubsystem.setIntake( 0 );
      RobotContainer.indexSubsystem.setRollers( 0 );

    }

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
