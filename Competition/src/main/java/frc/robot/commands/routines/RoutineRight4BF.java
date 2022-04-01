// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.routines;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RoutineRight4BF extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public RoutineRight4BF() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(9.65160762860162 , 5.739072006762945, new Rotation2d( 0.401870647440459 ) );
    DrivePath path4B = new DrivePath( "4B-1RightF" );



    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path4B, new SequentialCommandGroup( new WaitFor( 1 ), new RunBody( 0.05 ))
    ), new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup(new Intake(-0.8), new DrivePath( "4B-2RightF" ), 
    new SequentialCommandGroup( new WaitFor( 1 ), new WarmUp( 10,2100,0.57 ) ));
    ParallelRaceGroup group3 = new ParallelRaceGroup( new DrivePath( "4B-3RightF" ), 
    new Intake(-0.8) );
    ParallelRaceGroup group4 = new ParallelRaceGroup(new WaitFor(0.5), new Intake(-0.8), new SequentialCommandGroup( new RunBody(0.15)));
    ParallelRaceGroup group5 = new ParallelRaceGroup(new Intake(-0.8), new DrivePath( "4B-4RightF" ), 
    new SequentialCommandGroup( new WaitFor( 3 ), new WarmUp( 10, 2100,0.57 ) ) );

    addCommands( new Initialize(  initPose2d ),
    group1, group2,new WarmUp(1, 2100, 0.57), new ShootFor(0.7, 2100, 0.5), group3, group4, group5,new WarmUp(1, 2100, 0.57), new ShootFor(0.7, 2100, 0.5));
  }
}
