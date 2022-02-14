/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.PIDFController;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private static CANSparkMax shooter1 = new CANSparkMax( Constants.SHOOTER_ID_1, MotorType.kBrushless );
  private static CANSparkMax shooter2 = new CANSparkMax( Constants.SHOOTER_ID_2, MotorType.kBrushless );

  private static PIDFController controller = new PIDFController( 0.001, 0.001, 0, 0 );

  public void setShooter( double shooterValue ){
    shooter1.set(shooterValue);
    shooter2.set(shooterValue);
  }

  public void setShooterSpeed( double shooterSpeed ){
    controller.calculate( getSpeed(), shooterSpeed );
  }

  /**
   * @return average speed between the two motors
   */
  public double getSpeed(){
    return ( shooter1.getEncoder().getVelocity() + shooter2.getEncoder().getVelocity() ) / 2;
  }


  @Override
  public void periodic() {
  }
}