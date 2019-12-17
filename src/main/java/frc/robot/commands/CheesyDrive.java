/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CheesyDrive extends Command {
  public double multiplier = 1;

  public CheesyDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double stick1Y = Robot.oi.getDriverRawAxis( RobotMap.STICK_1_Y );
    double stick2X = Robot.oi.getDriverRawAxis( RobotMap.STICK_2_X );
    
    double deadzone = RobotMap.DRIVE_DEADZONE;

    stick1Y = ( Math.abs(stick1Y ) > deadzone )? stick1Y : 0;
    stick2X = ( Math.abs( stick2X ) > deadzone)? stick2X : 0;

    //stick1Y *= -1;

    double leftValue = stick2X - stick1Y;
    double rightValue = -stick2X - stick1Y;

    Robot.driveTrain.setLeftMotors( leftValue );
    Robot.driveTrain.setRightMotors( rightValue );

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotors( 0 );
    Robot.driveTrain.setRightMotors( 0 );
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
