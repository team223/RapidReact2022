// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Set;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveClimbers;
import frc.robot.commands.WaitFor;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new Climber. */
  private static CANSparkMax leftClimber = new CANSparkMax( Constants.LEFT_CLIMBER_ID, MotorType.kBrushless );
  private static CANSparkMax rightClimber = new CANSparkMax( Constants.RIGHT_CLIMBER_ID, MotorType.kBrushless );

  private static Solenoid actuation = new Solenoid( 1, PneumaticsModuleType.REVPH, 6 );
  
  public ClimberSubsystem() {
    resetPosition();
    actuation.set( true );
  }

  public void toggleSolenoid( ){
    actuation.toggle();
  }

  public void resetPosition(){
    leftClimber.getEncoder().setPosition( 0 );
    rightClimber.getEncoder().setPosition( 0 );
  }

  public double getPosition(){
    return -leftClimber.getEncoder().getPosition();
  }

  public void setClimbers( double speed ){
    /*
    leftClimber.burnFlash();
    rightClimber.burnFlash();
    */

    setLeftClimber(speed);
    setRightClimber(0.85 * speed);
    System.out.println( "Climbers: " +getPosition() );
  }

  public  SequentialCommandGroup group  = new SequentialCommandGroup(
    new DriveClimbers( 60 ),
    new InstantCommand(){
      @Override
      public void execute(){
        toggleSolenoid();
      }
    },
    new DriveClimbers( 190 ),
    new InstantCommand(){
      @Override
      public void execute(){
        toggleSolenoid();
      }
    }       
  );;
  public void runClimbers(){
    

      group.schedule();
  }

  public void ohShit(){
    try{
      
    }catch( Exception e ){
      
    }
  }

  public void setLeftClimber( double speed ){
    leftClimber.set( speed );
    if( -leftClimber.getEncoder().getPosition() >= 190 && speed < 0  ){
     // leftClimber.set( 0 );
    }else if( -leftClimber.getEncoder().getPosition() <= 0 && speed > 0 ){
      //leftClimber.set( 0 );
    }
  }

  public void setRightClimber( double speed ){
    rightClimber.set( speed );
    if( -rightClimber.getEncoder().getPosition() >= 190 && speed < 0  ){
     // rightClimber.set( 0 );
    }else if( -rightClimber.getEncoder().getPosition() <= 0 && speed > 0 ){
      //rightClimber.set( 0 );
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
