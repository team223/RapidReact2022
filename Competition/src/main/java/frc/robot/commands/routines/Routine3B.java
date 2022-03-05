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
public class Routine3B extends SequentialCommandGroup {
  /** Creates a new Routine2B. */
  public Routine3B() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    Pose2d initPose2d = new Pose2d(8.606178843254666 , 5.383410667418104, new Rotation2d( 1.5707963267948966 ) );
    DrivePath path3B = new DrivePath( "3B-1" );



    ParallelRaceGroup group1 = new ParallelRaceGroup( new ParallelCommandGroup( path3B, new SequentialCommandGroup( new WaitFor( 6 ), new RunBody( 0.15 ))
    ), new Intake( -0.8 ) );
    ParallelRaceGroup group2 = new ParallelRaceGroup( new DrivePath( "3B-2" ), 
    new SequentialCommandGroup( new WaitFor( 7 ), new ShootFor( 10, 0.4 ) ) );

    addCommands( new Initialize(  initPose2d ), new ShootFor( 0.75, 0.4 ),
    group1, group2);
  }
}
