//Auto command 1

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive1 extends SequentialCommandGroup {

  public AutoDrive1() {
    addRequirements(RobotContainer.driveSubsystem, RobotContainer.shooterSubsystem, RobotContainer.indexSubsystem, RobotContainer.intakeSubsystem);
    

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveSubsystem.setMotors(1,1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
