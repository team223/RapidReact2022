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
public class Routine2BMean extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine2BMean() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d( 10.352, 3.206, new Rotation2d( -0.733 ) );
    DrivePath mean1 = new DrivePath( "Mean1" );


    ParallelRaceGroup group1 = new ParallelRaceGroup( mean1, new Intake( -0.8 ) );
    //ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "Mean2" ), 
    //new SequentialCommandGroup( new WaitFor( 2.5 ), new ShootFor( 1, 0.4 ) ) );
    ParallelRaceGroup group3 = new ParallelRaceGroup( new DrivePath( "Mean3" ), new Intake( -0.8 ) );

    //addCommands( new Initialize(  initPose2d ), 
    //group1, group2, group3, new ShootFor( 2, 0.6 ));
  }
}
