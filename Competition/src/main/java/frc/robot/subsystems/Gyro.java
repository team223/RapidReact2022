package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


public class Gyro {

    private AHRS navX = new AHRS( SPI.Port.kMXP );
    private double zeroValue = 0;

    public double getAngle(){
        return navX.getAngle() - zeroValue;
    }

    public void reset( double angle ){
        zeroValue = navX.getAngle() - angle;
        System.out.println( "angle- " + angle + " value " + navX.getAngle() + " zero " + zeroValue);
    }

    public void reset(){
        reset( 0 );
    }
}
