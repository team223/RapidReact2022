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
public class RoutineLeft4BF extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public RoutineLeft4BF() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(6.235103247622401 ,  5.124747875167312, new Rotation2d( 2.4980915447965075 ) );
    DrivePath path4B = new DrivePath( "4B-1LeftF" );



    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path4B, new SequentialCommandGroup( new WaitFor( 1 ), new RunBody( 0.15 ))
    ), new Intake( -0 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "4B-2LeftF" ), 
    new SequentialCommandGroup( new WaitFor( 1 ), new WarmUp( 10,2100,0.5 ) ));
    ParallelRaceGroup group3 = new ParallelRaceGroup( new DrivePath( "4B-3LeftF" ), 
    new Intake(0) );
    ParallelRaceGroup group4 = new ParallelRaceGroup(new WaitFor(0.5), new Intake(0));
    ParallelRaceGroup group5 = new ParallelRaceGroup( new DrivePath( "4B-4LeftF" ), 
    new SequentialCommandGroup( new WaitFor( 2 ), new WarmUp( 10, 2100,0.5 ) ) );

    addCommands( new Initialize(  initPose2d ),
    group1, group2,new ShootFor(1.5, 2100, 0.5),new ShootFor(1.5, 2100, 0.5), group3, group4, group5,new ShootFor(1.5, 2100, 0.5), new ShootFor(1.5,2100,0.5));
  }}
