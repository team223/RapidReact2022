/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.IOException;
import java.nio.file.Path;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends SubsystemBase {
  public AHRS navX = new AHRS( SPI.Port.kMXP );
  private double startingAngle = 0;
  private double startingX = 9.5;
  private double startingY = 3.5;


  public Pose2d currentPose;

  public DifferentialDriveOdometry odometry = new DifferentialDriveOdometry( new Rotation2d( startingAngle ), new Pose2d( startingX, startingY, new Rotation2d( startingAngle ) ));

  public static double rotToMeters;

  private double previousLeftDistance = 0;
  private double previousRightDistance = 0;

  
  PIDController turnController;
  //public PIDController pid = new PIDController(Kp, Ki, Kd, Kf, ahrs);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static CANSparkMax[] leftMotors =
  {new CANSparkMax( 1, MotorType.kBrushless ), new CANSparkMax( 2, MotorType.kBrushless ), new CANSparkMax( 3, MotorType.kBrushless ) };

  private static CANSparkMax[] rightMotors = 
  {new CANSparkMax( 4, MotorType.kBrushless ), new CANSparkMax( 5, MotorType.kBrushless ), new CANSparkMax( 6, MotorType.kBrushless ) };

  public DriveSubsystem(){
    rotToMeters = (1 / 10.714 ) * ( 6 * 0.0254 * Math.PI ); 

    for( int i = 0; i < 2; i++ ){
      leftMotors[i].getEncoder().setPosition(0);
      rightMotors[i].getEncoder().setPosition(0);
    }
  }



  //DO NOT CHANGE
  public void setMotors( double left, double right ){
  leftMotors[0].set( left ); //1
  //System.out.println("left: " +  leftMotors[0].getEncoder().getVelocity());
  //leftMotors[1].set( left ); //2
  //leftMotors[2].set( left );  //3

  rightMotors[0].set( right ); //4
  //System.out.println("right: " + rightMotors[0].getEncoder().getVelocity());
 // rightMotors[1].set( right ); //5
  //rightMotors[2].set( right ); //6
/*
  leftMotors[0].burnFlash();
  leftMotors[1].burnFlash();
  leftMotors[2].burnFlash();
  rightMotors[0].burnFlash();
  rightMotors[1].burnFlash();
  rightMotors[2].burnFlash();
*/
  }

  public double getAverageEncoderVelocity(){
    double temp = 0.0;
    for (int i = 0; i < 3; i++){
        temp += Math.abs(leftMotors[i].getEncoder().getVelocity());
        temp += Math.abs(rightMotors[i].getEncoder().getVelocity());
    }
    if( rightMotors[0].getEncoder().getVelocity() < 0 ){ temp *= -1; }
    return temp / 6;
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

  public void PIDTest( boolean test ){
   
    
    if( test ){
      
    }
  }

  public Pose2d getPosition(){
    return currentPose;
  }

  public void cheezyDrive( double stick1, double stick2 ){
     
    if( Math.abs( stick1 ) < Constants.CONTROLLER_DEADZONE ){
      stick1 = 0;
    }
    if( Math.abs( stick2 ) < Constants.CONTROLLER_DEADZONE ){
      stick2 = 0;
    }

    //stick1 /= 3; stick2 /= 3;
    setMotors( stick1 - stick2, stick1 + stick2 );
    

  }

  @Override
  public void periodic() {
    // TODO Auto-generated method stub
    super.periodic();
    
    double distanceLeft = leftMotors[0].getEncoder().getPosition() - previousLeftDistance;
    double distanceRight = rightMotors[0].getEncoder().getPosition() - previousRightDistance;

    Rotation2d gyroAngle = Rotation2d.fromDegrees( -navX.getAngle() );
    currentPose = odometry.update( gyroAngle, distanceLeft * rotToMeters, distanceRight * rotToMeters );
    System.out.println( navX.getAngle() );
  }
}
