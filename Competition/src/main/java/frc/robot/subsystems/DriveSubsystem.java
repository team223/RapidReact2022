/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends SubsystemBase {

  private static CANSparkMax[] leftMotors =
  {new CANSparkMax( 1, MotorType.kBrushless ), new CANSparkMax( 2, MotorType.kBrushless ), new CANSparkMax( 3, MotorType.kBrushless ) };

  private static CANSparkMax[] rightMotors = 
  {new CANSparkMax( 4, MotorType.kBrushless ), new CANSparkMax( 5, MotorType.kBrushless ), new CANSparkMax( 6, MotorType.kBrushless ) };


  public void setMotors( double left, double right ){
    leftMotors[0].set( left ); 
    leftMotors[1].set( left ); 
    leftMotors[2].set( left );  

    rightMotors[0].set( right ); 
    rightMotors[1].set( right ); 
    rightMotors[2].set( right ); 
  }

  public void cheezyDrive( double stick1, double stick2 ){
    if( Math.abs( stick1 ) < Constants.CONTROLLER_DEADZONE ){
      stick1 = 0;
    }

    if( Math.abs( stick2 ) < Constants.CONTROLLER_DEADZONE ){
      stick2 = 0;
    }

    setMotors( stick1 + stick2, stick1 - stick2 );
  }
}