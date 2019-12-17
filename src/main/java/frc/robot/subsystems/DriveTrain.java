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
import frc.robot.RobotMap;
import frc.robot.commands.CheesyDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private CANSparkMax leftMotor1 = new CANSparkMax( RobotMap.LEFT_MOTOR_1,  MotorType.kBrushless );
  private CANSparkMax leftMotor2 = new CANSparkMax( RobotMap.LEFT_MOTOR_2, MotorType.kBrushless );

  private CANSparkMax rightMotor1 = new CANSparkMax( RobotMap.RIGHT_MOTOR_1, MotorType.kBrushless );
  private CANSparkMax rightMotor2 = new CANSparkMax( RobotMap.RIGHT_MOTOR_2, MotorType.kBrushless );

  private CANEncoder leftEncoder1 = new CANEncoder( leftMotor1 );
  private CANEncoder leftEncoder2 = new CANEncoder( leftMotor2 );

  private CANEncoder rightEncoder1 = new CANEncoder( rightMotor1 );
  private CANEncoder rightEncoder2 = new CANEncoder( rightMotor2 );

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CheesyDrive());

    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
  }

  public void setLeftMotors( double speed ){
    leftMotor1.set(speed);
    leftMotor2.set(speed);
  }

  public void setRightMotors( double speed ){
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }

  public void resetPositions(){
    leftEncoder1.setPosition(0);
    leftEncoder2.setPosition(0);

    rightEncoder1.setPosition(0);
    rightEncoder2.setPosition(0);
  }

  public void setLeftPosition( double position ){
    leftEncoder1.setPosition(position);
    leftEncoder2.setPosition(position);
  }

  public void setRightPosition( double position ){
    rightEncoder1.setPosition(position);
    rightEncoder2.setPosition(position);
  }

  public double getLeftMotorsPosition(){
    return ( leftEncoder1.getPosition() + leftEncoder2.getPosition() ) / 2;
  }

  public double getRightMotorsPosition(){
    return ( rightEncoder1.getPosition() + rightEncoder2.getPosition() ) / 2;
  }
}
