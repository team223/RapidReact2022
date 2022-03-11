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
public class Routine4B extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine4B() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(8.810953553786543 , 6.633614163296936, new Rotation2d( 1.5083775167989368 ) );
    DrivePath path4B = new DrivePath( "4B-1" );



    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path4B, new SequentialCommandGroup( new WaitFor( 6 ), new RunBody( 0.15 ))
    ), new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "4B-2" ), 
    new SequentialCommandGroup( new WaitFor( 2.5 ), new ShootFor( 10, 0.4 ) ) );
    ParallelRaceGroup group3 = new ParallelRaceGroup( new DrivePath( "4B-3" ), 
    new Intake(-0.8) );
    ParallelRaceGroup group4 = new ParallelRaceGroup( new DrivePath( "4B-4" ), 
    new SequentialCommandGroup( new WaitFor( 10 ), new ShootFor( 10, 0.4 ) ) );


    addCommands( new Initialize(  initPose2d ),
    group1, group2, group3, group4);
  }
}
