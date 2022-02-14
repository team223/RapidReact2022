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
  
    //SETS SHOOTER
    if( RobotContainer.joystick1.getRawButton( 4 ) ){
      RobotContainer.shooterSubsystem.setShooterSpeed( 1000 ); 
    } else if( RobotContainer.joystick1.getRawButton( 5 )){
      RobotContainer.shooterSubsystem.setShooter( 3000 ); 
    }else{
      RobotContainer.shooterSubsystem.setShooter(0);
    }

    //SETS GATEWAY
    if( RobotContainer.joystick1.getRawButton( 1 ) ){
      RobotContainer.indexSubsystem.setGateway( .25 );
    }else{
      RobotContainer.indexSubsystem.setGateway( 0 );
    }

    //SETS FEEDER
    if( RobotContainer.joystick1.getRawButton( 2 ) ){
      RobotContainer.indexSubsystem.setFeeder( .25 );
    }else{
      RobotContainer.indexSubsystem.setFeeder( 0 );
    }

    //SETS INTAKE
    if( RobotContainer.joystick1.getRawButton( 0 ) ){
      RobotContainer.intakeSubsystem.setIntake( 0.5 );
    }else{
      RobotContainer.intakeSubsystem.setIntake( 0 );
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