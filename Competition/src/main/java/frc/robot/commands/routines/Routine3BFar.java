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
public class Routine3BFar extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine3BFar() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(9.953380886227544 , 5.728294390419162, new Rotation2d( 0.7853981633974514 ) );
    DrivePath path3B = new DrivePath( "3B-1Far" );



    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path3B, new SequentialCommandGroup( new WaitFor( 3 ), new RunBody( 0.15 ))
    ), new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "3B-2Far" ), 
    new SequentialCommandGroup( new WaitFor( 2.5 ), new ShootFor( 1.5, 2200,0.95 ), new ShootFor(1.5,2200,0.95) ),new Intake(-0.8) );

    addCommands( new Initialize(  initPose2d ), new ShootFor( 1.5, 2200,0.95 ),
    group1, group2);
  }
}
