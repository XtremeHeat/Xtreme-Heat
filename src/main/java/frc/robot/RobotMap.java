/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap{
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;


 
  
  public static final double DRIVE_DEADZONE = 0.12;
  public static final double OPERATE_DEADZONE = 0.12;

  public static final int LEFT_MOTOR_1 = 3;
  public static final int LEFT_MOTOR_2 = 4;

  public static final int RIGHT_MOTOR_1 = 1;
  public static final int RIGHT_MOTOR_2 = 2;

  public static final int STICK_1_Y = 1;
  public static final int STICK_2_X = 4;

  public static final int DRIVE_PORT = 0;
  public static final int OPERATOR_PORT = 1;

  public static final double MAXIMUM_ELEVATOR_SPEED = 4000;
  public static final double MAXIMUN_ELEVATOR_HEIGHT = 110;


 // public static final 

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

}
