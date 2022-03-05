/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.ejml.dense.row.linsol.qr.SolveNullSpaceQRP_DDRM;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  private static CANSparkMax intake = new CANSparkMax( Constants.INTAKE_ID, MotorType.kBrushless );

  private static Solenoid solenoid = new Solenoid( 1, PneumaticsModuleType.REVPH, 7 );

  
  public void setIntake( double intakeValue ){
    intake.set( -intakeValue );
  }

  public void setPiston( boolean on ){
    solenoid.set( on );
  }

  public void toggleSolenoid( ){
    solenoid.toggle();

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}