// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new Climber. */
  private static CANSparkMax leftClimber = new CANSparkMax( Constants.LEFT_CLIMBER_ID, MotorType.kBrushless );
 private static CANSparkMax rightClimber = new CANSparkMax( Constants.RIGHT_CLIMBER_ID, MotorType.kBrushless );


  private static Solenoid actuation = new Solenoid( 1, PneumaticsModuleType.REVPH, 6 );
  
  public ClimberSubsystem() {}

  public void toggleSolenoid( ){
    actuation.toggle();
  }

  public void setClimbers( double speed ){
    leftClimber.set( speed );
    rightClimber.set( -speed );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
