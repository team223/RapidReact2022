package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


public class Gyro {

    private AHRS navX = new AHRS( SPI.Port.kMXP );
    private double zeroValue = 0;

    public double getAngle(){
        return navX.getAngle() - zeroValue;
    }

    public void reset(){
        zeroValue = getAngle();
    }
}
