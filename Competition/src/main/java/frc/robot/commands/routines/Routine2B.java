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
public class Routine2B extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine2B() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d( 10.578, 2.948, new Rotation2d( -0.7853981633974483 ) );
    DrivePath path2B = new DrivePath( "2B-1S" );


    ParallelRaceGroup group1 = new ParallelRaceGroup( path2B, new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "2B-2S" ), 
    new SequentialCommandGroup( new WaitFor( 3 ), new ShootFor( 1.3, 2000, 0.75 ) ), new ShootFor(1.3,2000,0.75) );

    addCommands( new Initialize(  initPose2d ), 
    group1, group2);
  }
}
