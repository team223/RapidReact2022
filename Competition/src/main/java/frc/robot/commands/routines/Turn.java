package frc.robot.commands.routines;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class Turn extends SequentialCommandGroup {
    public Turn(){

        Pose2d initPose2d = new Pose2d( 0, 0, new Rotation2d( -0.7853981633974494 ) );
        //DrivePath pathTest = new DrivePath(  );
    
    
        //ParallelRaceGroup group1 = new ParallelRaceGroup( pathTest );
        
    
       // addCommands(new Initialize(  initPose2d ), group1);
    }
}
