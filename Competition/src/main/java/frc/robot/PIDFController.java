// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class PIDFController{

    private double kp = 0;
    private double ki = 0;
    private double kd = 0;
    private double kf = 0;

    private double previousError = 0;
    private double integral = 0;

    public PIDFController(double kp, double ki, double kd, double kf) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.kf = kf;
    }

    public void reset(){
        integral = 0;
    }

    public double calculate(double measurement, double setpoint) {
        if( Math.abs( measurement ) < 0.0001 ){
            //integral = 0;
            System.out.println( "RESET!!!" );
            return kf;
        }
        
        double error = setpoint - measurement;
        integral += error;
        double derivative = error - previousError;

        previousError = error;
        

        return error * kp + integral * ki + derivative * kd;
    }

    

}
