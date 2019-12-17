/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.UseBody;

import frc.robot.Timer;

/**
 * Add your docs here.
 */
public class RobotBody extends Subsystem {
  private Timer elevatorTimer = new Timer();

  private Robot robot = new Robot();

  private CANSparkMax elevator = new CANSparkMax( 11, MotorType.kBrushless );
  private CANSparkMax elevator2 = new CANSparkMax( 10, MotorType.kBrushless );
  private CANSparkMax wrist = new CANSparkMax( 9 , MotorType.kBrushless );

  private CANEncoder elevatorEncoder = new CANEncoder( elevator );
  private CANEncoder elevator2Encoder = new CANEncoder( elevator2 );
  private CANEncoder wristEncoder = new CANEncoder( wrist );

  private double targetPosition;


  @Override
  public void initDefaultCommand() {
    setDefaultCommand( new UseBody() );

    elevator.setInverted(true);
    targetPosition = 0;
  }

  public void setElevator( double speed ){
    elevator.set( -speed );
    elevator2.set( -speed );
  }

  public void setWrist( double speed ){
    wrist.set( speed ); 
  }

  public double getElevatorPosition(){
    return ( elevatorEncoder.getPosition() + elevator2Encoder.getPosition() ) / 2;
  }

  public double getElevatorVelocity(){
    return ( elevatorEncoder.getVelocity() + elevator2Encoder.getVelocity() ) / 2;
  }

  //prevents falling of elevator
  public double elevatorAdjustments( double speed ){
    //gets speed in r/ms
    double currentSpeed = ( -( RobotMap.MAXIMUM_ELEVATOR_SPEED * speed ) * ( robot.getPeriod() / .001 ) / 60000 );

    targetPosition += currentSpeed;
     
    double positionDifference =  this.getElevatorPosition() - targetPosition ;

    
    
  /*
    if( speed == 0 ){
      return -0.05;
    }
    */
    return speed;


  }
}
