/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private static CANSparkMax shooter1 = new CANSparkMax( Constants.SHOOTER_ID_1, MotorType.kBrushless );
  private static CANSparkMax shooter2 = new CANSparkMax( Constants.SHOOTER_ID_2, MotorType.kBrushless );

  public void setShooter( double shooterValue ){
    shooter1.set(shooterValue);
    shooter2.set(-shooterValue);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
