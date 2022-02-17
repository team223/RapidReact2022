/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  private static CANSparkMax intake = new CANSparkMax( Constants.INTAKE_ID, MotorType.kBrushless );

  private static DoubleSolenoid intakeSolenoid = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, 0, 1 );
  
  public void setIntake( double intakeValue ){
    intake.set( -intakeValue );
  }

  public void toggleSolenoid(){
    intakeSolenoid.toggle();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}