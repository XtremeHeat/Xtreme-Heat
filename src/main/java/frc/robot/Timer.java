/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
/**
 * Add your docs here.
 */
public class Timer {

    private double startTime;
    private double previousTime;

    public void startTimer(){
        if( startTime == 0 )
            startTime = System.currentTimeMillis();
    }

    public void stopTimer(){
        startTime = 0;
    }

    public double getTimeMillis(){
        return System.currentTimeMillis() - startTime;
    }

    public double getTimeSec(){
        return getTimeMillis() / 1000;
    }

    public double getTimeMin(){
        return getTimeSec() / 60;
    }

    public void waitFor( double timeToWait ){
        double startingTime = getTimeMillis();
        double currentTime;
        do{
            currentTime = getTimeMillis() - startingTime;
        }while( currentTime < timeToWait );
    }

    public void regulateTime( double timeStamp ){
        
        double currentTime = getTimeMillis();

        while( previousTime + timeStamp < currentTime ){
            currentTime = getTimeMillis();
        }
    }
}
