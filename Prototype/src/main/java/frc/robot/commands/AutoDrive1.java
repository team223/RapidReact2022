//Auto command 1

package frc.robot.commands;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.PIDFController;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive1 extends SequentialCommandGroup {

  private static long startTimeMillis = 0;
  private Trajectory trajectory;
  private PIDFController drivePid;

  private DifferentialDriveKinematics kinematics;
  private String trajectoryJSON;

  public AutoDrive1( String trajectoryJSON ) {
    addRequirements(RobotContainer.driveSubsystem, RobotContainer.shooterSubsystem, RobotContainer.indexSubsystem, RobotContainer.intakeSubsystem);
    
    this.trajectoryJSON = "output/" + trajectoryJSON + ".wpilib.json";
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivePid = new PIDFController( .3, 0.02, 0, 0.03 );
    try {
      
      Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
      trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
   } catch (IOException ex) {
     System.out.println( "Unable to open trajectory: " + trajectoryJSON );
   }

   kinematics = new DifferentialDriveKinematics( Units.inchesToMeters( 23.5 ) );

   startTimeMillis = System.currentTimeMillis();
   System.out.println( "start!" );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RamseteController controller = new RamseteController();

    double currentTime = (double)(System.currentTimeMillis() - startTimeMillis ) / 1000;
    Trajectory.State goal = trajectory.sample(  currentTime );
    ChassisSpeeds updatedSpeeds = controller.calculate( RobotContainer.driveSubsystem.getPosition(), goal );
    DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(updatedSpeeds);
    double left = wheelSpeeds.leftMetersPerSecond;

    SmartDashboard.putNumber( "Target X", goal.poseMeters.getX());        SmartDashboard.putNumber( "Target Y", goal.poseMeters.getY());
    SmartDashboard.putNumber( "Actual X", RobotContainer.driveSubsystem.getPosition().getX());        SmartDashboard.putNumber( "Actual Y", RobotContainer.driveSubsystem.getPosition().getY());

    
    double right = wheelSpeeds.rightMetersPerSecond;

    double leftSpeed = RobotContainer.driveSubsystem.getLeftEncoderVelocity() * DriveSubsystem.rotToMeters / 60;
    double rightSpeed = RobotContainer.driveSubsystem.getRightEncoderVelocity() * DriveSubsystem.rotToMeters / 60;
    
    System.out.println( leftSpeed + "vs" + left );

    RobotContainer.driveSubsystem.setMotors( drivePid.calculate( leftSpeed, left ), drivePid.calculate( rightSpeed, right  ) );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.setMotors(0,0);
    System.out.println( "end!" );

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (double)(System.currentTimeMillis() - startTimeMillis ) / 1000 > trajectory.getTotalTimeSeconds();
  }
}
