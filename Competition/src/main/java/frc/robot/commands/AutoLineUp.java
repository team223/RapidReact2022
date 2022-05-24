package frc.robot.commands;

import frc.robot.Limelight;
import frc.robot.PIDFController;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class AutoLineUp {
    private double error = Limelight.getX();
    private double Kp = 0.1;


   
    public void execute() {
        double steering_adjust = error * Kp;
        RobotContainer.driveSubsystem.setMotors(left_Speed+=steering_adjust);
    }


  
   public void end(boolean interrupted) {
     RobotContainer.driveSubsystem.setMotors( 0, 0 );
   }
 



}
