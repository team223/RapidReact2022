/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.CargoColor;

public class IndexSubsystem extends SubsystemBase {

  private static TalonSRX feeder = new TalonSRX( Constants.FEEDER_ID );

  private final int SINGULATOR_EMPTY = 200;

  public DigitalInput[] ballSensor = { new DigitalInput( 0 ), new DigitalInput( 3 ), new DigitalInput( 4 ) };
  public DigitalInput colorSensor = new DigitalInput( 5 );
  public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-intake");


  public boolean getBallSensor( int sensor){
    return ballSensor[sensor].get( );
  }

  public boolean hasTwoBalls(){
    if( ballSensor[0].get() || ballSensor[2].get() ){
      return false;
    }
    return true;
  }

  public boolean hasThreeBalls(){
    for( int i = 0; i < ballSensor.length; i++ ){
      if( ballSensor[i].get() ){
        return false;
      }
    }

    return true;
  }

  public void setFeeder( double feederValue ){
    feeder.set( ControlMode.PercentOutput, -feederValue );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}