/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  /**
   * Creates a new IndexSubsystem.
   */
  private static TalonSRX tower = new TalonSRX( Constants.TOWER_ID );

  private static TalonSRX leftRoller = new TalonSRX( Constants.LEFT_ROLLER_ID );
  private static TalonSRX rightRoller = new TalonSRX( Constants.RIGHT_ROLLER_ID );

  public void setRollers( double rollerValue ){
    leftRoller.set( ControlMode.PercentOutput, rollerValue );
    rightRoller.set( ControlMode.PercentOutput, -rollerValue );
  }

  public void setTower( double intakeValue ){
    tower.set( ControlMode.PercentOutput, intakeValue );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
