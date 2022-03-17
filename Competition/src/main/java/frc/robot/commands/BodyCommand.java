/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;

public class BodyCommand extends CommandBase {

  private boolean buttonPressed = false;
  private boolean canToggle = false;

  private boolean buttonPressed1 = false;
  private boolean canToggle1 = false;

  private boolean buttonPressed2 = false;
  private boolean canToggle2 = false;

  public BodyCommand() {
    addRequirements( RobotContainer.shooterSubsystem
    , RobotContainer.indexSubsystem, RobotContainer.intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  public boolean manual = true;

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    
    //EXECUTES COMMAND THAT TOGGLES INTAKE SOLENOID ON BUTTON PRESS
    if( RobotContainer.joystick1.getRawAxis( 2 ) > 0.5 ){
      buttonPressed = true;
    }else{
      buttonPressed = false;
      canToggle = true;
    }

    if( buttonPressed && canToggle ){
      RobotContainer.intakeSubsystem.toggleSolenoid();
      buttonPressed = false;
      canToggle = false;

    }

    //Oh SHit toggle
    if( RobotContainer.joystick2.getRawButton( 7 ) ){
      buttonPressed2 = true;
    }else{
      buttonPressed2 = false;
      canToggle2 = true;
    }

    if( buttonPressed2 && canToggle2 ){
      manual = !manual;
      RobotContainer.climberSubsystem.ohShit();
      buttonPressed1 = false;
      canToggle1 = false;
    }


    //SETS CLIMBERS
    if( !manual ){
      RobotContainer.climberSubsystem.setClimbers( RobotContainer.joystick2.getRawAxis( 1 ) );

    }else{
      RobotContainer.climberSubsystem.setLeftClimber(RobotContainer.joystick2.getRawAxis( 5 ));
      RobotContainer.climberSubsystem.setRightClimber( RobotContainer.joystick2.getRawAxis( 1 ) );
    }

     //EXECUTES COMMAND THAT TOGGLES CLIMBER SOLENOID ON BUTTON PRESS
     if( RobotContainer.joystick2.getRawButton( 4 ) ){
      buttonPressed1 = true;
    }else{
      buttonPressed1 = false;
      canToggle1 = true;
    }

    if( buttonPressed1 && canToggle1 ){
      if( !manual ){
        RobotContainer.climberSubsystem.runClimbers();
      }else{
        RobotContainer.climberSubsystem.toggleSolenoid();
      }
      buttonPressed1 = false;
      canToggle1 = false;

    }

    //RobotContainer.indexSubsystem.runCompressor();

    //SETS FEEDER
    if( RobotContainer.joystick2.getRawButton( 2 ) ){
      RobotContainer.indexSubsystem.setFeeder( 0.75 );
    }else{
      RobotContainer.indexSubsystem.setFeeder( 0 );
    }

    //SETS SHOOTER
    if( RobotContainer.joystick2.getRawButton( 6 ) ){
      RobotContainer.shooterSubsystem.setShooter(1); 
    } else if( RobotContainer.joystick2.getRawButton( 5 )){
      RobotContainer.shooterSubsystem.setShooterSpeed( 2000 ); 
    }else{
      RobotContainer.shooterSubsystem.resetPID();
      RobotContainer.shooterSubsystem.setShooter(0);
    }

    
    //SETS INTAKE
    if( RobotContainer.joystick1.getRawAxis( 3 ) > 0.5 ){
      RobotContainer.intakeSubsystem.setIntake( -1 );
      RobotContainer.indexSubsystem.setGateway( -.5 );
      if( RobotContainer.indexSubsystem.getBallSensor() ){
        RobotContainer.indexSubsystem.setFeeder( 0.3 );
      }
    }else if( RobotContainer.joystick2.getRawButton( 3 ) ){
      RobotContainer.intakeSubsystem.setIntake( 1 );
      RobotContainer.indexSubsystem.setFeeder(-0.5);
      RobotContainer.shooterSubsystem.setShooter( -0.5 );
    }else{
      RobotContainer.intakeSubsystem.setIntake( 0 );
      RobotContainer.indexSubsystem.setGateway( 0 );

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