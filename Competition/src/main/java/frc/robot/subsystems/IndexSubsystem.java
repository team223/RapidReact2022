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

  private static TalonSRX gateway = new TalonSRX( Constants.GATEWAY_ID );
  private static TalonSRX feeder = new TalonSRX( Constants.FEEDER_ID );

  private final int SINGULATOR_EMPTY = 200;

  private static DigitalInput beamSensor = new DigitalInput( 0 );
  public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-intake");

  public void setGateway( double gatewayValue ){
    gateway.set( ControlMode.PercentOutput, gatewayValue );
  }

  public boolean getBeamSensor(){
    return beamSensor.get();
  }

  private double proximity;
  private double red;
  private double green;
  private double blue;
  private boolean isRed;

  private boolean allianceRed = true;

  public void displayCargoColor() {
    double [] defaultColor = {0, 0, 0};
    proximity = table.getEntry("proximity1").getDouble(0.0);
    red = table.getEntry("likelycolor1").getDoubleArray(defaultColor)[0];
    green = table.getEntry("likelycolor1").getDoubleArray(defaultColor)[1];
    blue = table.getEntry("likelycolor1").getDoubleArray(defaultColor)[2];

    SmartDashboard.putNumber("red", red);
    SmartDashboard.putNumber("green", green);
    SmartDashboard.putNumber("blue", blue);

    if (proximity < SINGULATOR_EMPTY) {

    } 

    if (red > 1.2 * blue) {
      isRed = true;
      SmartDashboard.putString("RawColor", "RED");
    } else if (blue > 1.2 * red) {
      isRed = false;
      SmartDashboard.putString("RawColor", "BLUE");
    }
  }

  public void setFeeder( double feederValue ){
    feeder.set( ControlMode.PercentOutput, feederValue );
  }

  @Override
  public void periodic() {
    displayCargoColor();
    // This method will be called once per scheduler run
  }
}