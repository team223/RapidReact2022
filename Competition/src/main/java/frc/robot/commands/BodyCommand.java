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
  private int twoBallCounter = 0;
  private int threeBallCounter = 0;
  private int shooterCounter = 0;
  private boolean colorChecked = false;

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


    //SETS SHOOTER
    if( RobotContainer.joystick2.getRawButton( 6 ) ){

      // Batter
      RobotContainer.shooterSubsystem.setShooterSpeed( 2400 );
      RobotContainer.shooterSubsystem.setRoller(0.8 ); 

      //Low
      /*
      RobotContainer.shooterSubsystem.setShooterSpeed( 2500 );
      RobotContainer.shooterSubsystem.setRoller(-0.35 ); 
      */
      
    } else if( RobotContainer.joystick2.getRawButton( 5 )){
      
      // Far
      RobotContainer.shooterSubsystem.setShooterSpeed( 2100 );
      RobotContainer.shooterSubsystem.setRoller(0.65 ); 
     
    }else{
      RobotContainer.shooterSubsystem.resetPID();
      RobotContainer.shooterSubsystem.setShooter(0);
    }


    
    //SETS FEEDER
    if( RobotContainer.joystick2.getRawButton( 2 ) ){
      shooterCounter++;
      if( shooterCounter > 40 ){
        RobotContainer.indexSubsystem.setFeeder( 0.75 );
      }else if( shooterCounter <= 6 ){
        RobotContainer.indexSubsystem.setFeeder( 0.75 );
      }else{
        RobotContainer.indexSubsystem.setFeeder( 0);

      }
    }else{
      shooterCounter = 0;
      RobotContainer.indexSubsystem.setFeeder( 0 );
    }

    
    //SETS INTAKE
    if( RobotContainer.joystick1.getRawAxis( 3 ) > 0.5 ){
      RobotContainer.intakeSubsystem.setIntake( -1 );
      if( RobotContainer.indexSubsystem.getBallSensor( 0 ) ){
        RobotContainer.indexSubsystem.setFeeder( 0.5 );
      }
    }else{
      
     
      RobotContainer.intakeSubsystem.setIntake( 0 );

    }

    if(RobotContainer.indexSubsystem.hasTwoBalls() ){
      if( twoBallCounter >= 50 && twoBallCounter < 60 ){
        RobotContainer.intakeSubsystem.setPiston(false);
        twoBallCounter++;
      }else if( twoBallCounter > 60 ){
      }else{
        twoBallCounter++;

      }
    }else{
      twoBallCounter = 0;
    }

    if(RobotContainer.indexSubsystem.hasThreeBalls() && RobotContainer.intakeSubsystem.getPiston() ){
      if( threeBallCounter >= 25 ){
        SpitFor spitFor = new SpitFor( 1 );
        spitFor.schedule();
        threeBallCounter = 0;
      }else{
        threeBallCounter++;
      }
    }else{
      threeBallCounter = 0;
    }

    if( RobotContainer.joystick2.getRawButton( 3 ) ){
      RobotContainer.intakeSubsystem.setIntake( 1 );
      RobotContainer.indexSubsystem.setFeeder(-0.7);
      RobotContainer.shooterSubsystem.setShooter( -0.5 );
      RobotContainer.intakeSubsystem.setPiston(true);

    }

    if( RobotContainer.indexSubsystem.ballSensor[2].get() ){
      if( !colorChecked ){
        if( RobotContainer.indexSubsystem.colorSensor.get() ){
        }else{
        }
      }

      colorChecked = true;
    }else{
      colorChecked = false;
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