// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.routines;

import javax.swing.GroupLayout.ParallelGroup;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Routine5BF extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine5BF() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(8.875619251849244 , 5.189413573230011, new Rotation2d( 1.2722973952087244 ) );
    DrivePath path4B = new DrivePath( "5B-1F" );
    RobotContainer.intakeSubsystem.toggleSolenoid();


    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path4B, new SequentialCommandGroup( new WaitFor( 1 ), new RunBody( 0.15 ))
    ), new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "5B-2F" ), 
    new SequentialCommandGroup( new WaitFor( 2 ),  new ShootFor( 1.5,2000,0.65 ),new ShootFor( 1.5,2000,0.65  ) ), new Intake(-0.8), new RunBody(0.15));
    ParallelRaceGroup group3 = new ParallelRaceGroup( new DrivePath( "5B-3F" ), 
    new Intake(-0.8) );
    SequentialCommandGroup group4 = new SequentialCommandGroup( new ParallelRaceGroup(new WaitFor(0.5),new Intake(-0.8)), new ParallelRaceGroup( new DrivePath( "5B-4F" ), 
    new SequentialCommandGroup( new WaitFor( 2 ), new ShootFor( 1.5, 2000,0.65 ),new ShootFor( 1.5, 2000,0.65 ) ) ));


    addCommands( new Initialize(  initPose2d ), new ShootFor( 1.5, 2000,0.65 ),
    group1, group2, group3, group4);
  }
}
