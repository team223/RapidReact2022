/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.PIDFController;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private static CANSparkMax shooter1 = new CANSparkMax( Constants.SHOOTER_ID_1, MotorType.kBrushless );
  private static CANSparkMax shooter2 = new CANSparkMax( Constants.SHOOTER_ID_2, MotorType.kBrushless );

  private static TalonSRX roller = new TalonSRX( Constants.ROLLER_ID );

  private static Limelight limelight = new Limelight();

  private static PIDFController controller = new PIDFController( 0.0001, 0.00002, 0, 0.04 );

  public ShooterSubsystem(){
  }
  public void setShooter( double shooterValue ){
    shooter1.set(-shooterValue);
    shooter2.set(shooterValue);
    setRoller(0);
    if( shooterValue > 0.15 ){
    setRoller( 0.6 );
    }else{setRoller(0);}

  }

  public void setShooterSpeed( double shooterSpeed ){
    double speed = controller.calculate( getSpeed(), shooterSpeed );
    shooter1.set(-speed);
    shooter2.set(speed);
    //setRoller( 0.5 );
  }

  public void setRoller( double rollerSpeed ){
    roller.set( ControlMode.PercentOutput, rollerSpeed );
  }

  public double getRollerSpeed(){
    return 0;
  }


  public void resetPID(){
    controller.reset();
  }

  /**
   * @return average speed between the two motors
   */
  public double getSpeed(){
    return ( -shooter1.getEncoder().getVelocity() + shooter2.getEncoder().getVelocity() ) / 2;
  }


  @Override
  public void periodic() {
  }
}