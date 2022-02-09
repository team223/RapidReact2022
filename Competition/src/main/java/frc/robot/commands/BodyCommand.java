/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class BodyCommand extends CommandBase {
  /**
   * Creates a new BodyCommand.
   */
  private double inputValue = 0.75;
  private double targetValue = 0;

  private double kI = 0.001;
  private double kP = 0.001;
  private double kD = 0;

  private double IValue = 0;
  private double prevPValue = 0;
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
  public void execute() {/*
    SmartDashboard.putNumber( "Shooter Percent", SmartDashboard.getNumber( "Shooter Percent", inputValue ));
     inputValue = SmartDashboard.getNumber( "Shooter Percent", inputValue );
    
    SmartDashboard.putNumber( "Shooter Target( PID )", SmartDashboard.getNumber( "Shooter Target( PID )", targetValue ));
    targetValue = SmartDashboard.getNumber( "Shooter Target( PID )", targetValue );
    SmartDashboard.putNumber( "kI", SmartDashboard.getNumber( "kI", kI ));
    kI = SmartDashboard.getNumber( "kI", kI );
    SmartDashboard.putNumber( "kP", SmartDashboard.getNumber( "kP", kP ));
    kP = SmartDashboard.getNumber( "kP", kP );
    SmartDashboard.putNumber( "kD", SmartDashboard.getNumber( "kD", kD ));
    kD = SmartDashboard.getNumber( "kD", kD );
    
    if( RobotContainer.joystick1.getRawButton( 1 ) ){
      RobotContainer.shooterSubsystem.setShooter( inputValue ); 
    } else if( RobotContainer.joystick1.getRawButton( 2 )){
      RobotContainer.shooterSubsystem.setShooter(.5); 
    }else if( RobotContainer.joystick1.getRawButton( 3 ) ){
      shooterPID( targetValue);
    }else if( RobotContainer.joystick1.getRawButton( 4 ) ){
      RobotContainer.shooterSubsystem.setShooter(1); 
    }else{
      RobotContainer.shooterSubsystem.setShooter(0); IValue = 0;
    }
    if( RobotContainer.joystick1.getRawButton(6 ) ){
      RobotContainer.indexSubsystem.setTower( .25 );
    }else if( RobotContainer.joystick1.getRawButton( 7 ) ){
      RobotContainer.indexSubsystem.setTower( .6 );
    }else if( RobotContainer.joystick1.getRawButton( 8 ) ){
      RobotContainer.indexSubsystem.setTower( -.25 );
    }else{
      RobotContainer.indexSubsystem.setTower( 0 );
    }
    if( RobotContainer.joystick1.getRawButton( 5 ) ){
      RobotContainer.intakeSubsystem.setIntake( 0.75 );
      RobotContainer.indexSubsystem.setRollers( 0.5 );
    }else{
      RobotContainer.intakeSubsystem.setIntake( 0 );
      RobotContainer.indexSubsystem.setRollers( 0 );
    }*/

 }
/*
 private void shooterPID( double target ){
    double PValue = target - RobotContainer.shooterSubsystem.getSpeed();
    IValue += PValue;
    double dValue = PValue - prevPValue;
    RobotContainer.shooterSubsystem.setShooter( PValue * kP + IValue * kI + dValue * kD );
  
    prevPValue = PValue;
 }*/

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