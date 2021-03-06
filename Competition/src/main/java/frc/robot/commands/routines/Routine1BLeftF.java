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
public class Routine1BLeftF extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine1BLeftF() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d( 8.336738434660091, 5.372633051074322, new Rotation2d( 1 ) );
    DrivePath path1B = new DrivePath( "1B-LeftF" );


    ParallelRaceGroup group1 = new ParallelRaceGroup( path1B, new Intake( -0.8 ) );

    addCommands( new Initialize(  initPose2d ),new ShootFor( 1.3, 2300, 0.75 ), group1);
  }
}
