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
public class Routine2BLeft extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine2BLeft() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d( 8.994173031630856, 6.601281314265586, new Rotation2d( 1.5707963267948966 ) );
    DrivePath path2B = new DrivePath( "2B-1Left" );


    ParallelRaceGroup group1 = new ParallelRaceGroup( path2B, new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "2B-2Left" ), 
    new SequentialCommandGroup( new WaitFor( 3 ), new ShootFor( 10, 0.4 ) ) );

    addCommands( new Initialize(  initPose2d ), 
    group1, group2);
  }
}
