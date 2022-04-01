/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-intake");
  
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  public double getX(){
    return tx.getDouble( 0.0 );
  }

  public double getDistance(){
    return ((8*12) + 6 ) / Math.tan( Math.toDegrees( Constants.LIMELIGHT_ANGLE + getY() ));
  }

  public double getY(){
    return ty.getDouble( 0.0 );
  }

  public double getArea(){
    return ta.getDouble( 0.0 );
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    
  }
}
