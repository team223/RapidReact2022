/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  /**
   * Creates a new IndexSubsystem.
   */
  private static PWMTalonSRX tower = new PWMTalonSRX( Constants.TOWER_ID );

  private static PWMTalonSRX leftRoller = new PWMTalonSRX( Constants.LEFT_ROLLER_ID );
  private static PWMTalonSRX rightRoller = new PWMTalonSRX( Constants.RIGHT_ROLLER_ID );

  public void setRollers( double rollerValue ){
    leftRoller.set( rollerValue );
    rightRoller.set( -rollerValue );
  }

  public void setTower( double intakeValue ){
    tower.set( intakeValue );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
