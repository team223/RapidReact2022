/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends SubsystemBase {

  private Gyro gyroscope = new Gyro();

  private Pose2d currentPose = new Pose2d();
  private DifferentialDriveOdometry odometry;

  //Conversion factor between rotations and meters
  public static final double rotToMeters = (1 / 10.714 ) * ( 6 * 0.0254 * Math.PI ); 

  //Used in order to find change of position
  private double previousLeftDistance = 0;
  private double previousRightDistance = 0;

  private static CANSparkMax[] leftMotors =
  {new CANSparkMax( 1, MotorType.kBrushless ), new CANSparkMax( 2, MotorType.kBrushless ), new CANSparkMax( 3, MotorType.kBrushless ) };

  private static CANSparkMax[] rightMotors = 
  {new CANSparkMax( 4, MotorType.kBrushless ), new CANSparkMax( 5, MotorType.kBrushless ), new CANSparkMax( 6, MotorType.kBrushless ) };

  //CONSTRUCTOR
  public DriveSubsystem(){
    odometry = new DifferentialDriveOdometry( new Rotation2d( 0 ) );
    for( int i = 0; i < 2; i++ ){
      leftMotors[i].getEncoder().setPosition(0);
      rightMotors[i].getEncoder().setPosition(0);
    }
  }

  //RESETS VALUES
  public void reset( Pose2d pose2d ){
    gyroscope.reset();

    odometry = new DifferentialDriveOdometry( pose2d.getRotation(), pose2d );

    for( int i = 0; i < 2; i++ ){
      leftMotors[i].getEncoder().setPosition(0);
      rightMotors[i].getEncoder().setPosition(0);
    }
  }

  //MOTOR SETTING METHODS
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

  //ACCESSOR METHODS
  public double getAngle(){
    return gyroscope.getAngle();
  }

  public double getLeftEncoderVelocity(){
    double temp = 0.0;
    for (int i = 0; i < 3; i++){
        temp += Math.abs(leftMotors[i].getEncoder().getVelocity());
    }
    if( leftMotors[0].getEncoder().getVelocity() < 0 ){ temp *= -1; }
    return temp / 3;
  }

  public double getRightEncoderVelocity(){
    double temp = 0.0;
    for (int i = 0; i < 3; i++){
        temp += Math.abs(rightMotors[i].getEncoder().getVelocity());
    }

    if( rightMotors[0].getEncoder().getVelocity() < 0 ){ temp *= -1; }
    return temp / 3;
  }
  
  public Pose2d getPosition(){
    return currentPose;
  }

  //PERIODIC
  @Override
  public void periodic(){
    super.periodic();

    //Calculates the change during the period
    double distanceLeft = leftMotors[0].getEncoder().getPosition() - previousLeftDistance;
    double distanceRight = rightMotors[0].getEncoder().getPosition() - previousRightDistance;
  
    //Calculates current position
    Rotation2d gyroAngle = Rotation2d.fromDegrees( -gyroscope.getAngle() );
    currentPose = odometry.update( gyroAngle, distanceLeft * rotToMeters, distanceRight * rotToMeters );

  }

}