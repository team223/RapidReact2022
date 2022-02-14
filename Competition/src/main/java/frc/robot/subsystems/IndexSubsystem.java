/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {

  private static TalonSRX gateway = new TalonSRX( Constants.GATEWAY_ID );
  private static TalonSRX feeder = new TalonSRX( Constants.FEEDER_ID );


  public void setGateway( double gatewayValue ){
    gateway.set( ControlMode.PercentOutput, gatewayValue );
  }


  public void setFeeder( double feederValue ){
    feeder.set( ControlMode.PercentOutput, feederValue );
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}