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
import frc.robot.subsystems.RobotBody;

public class UseBody extends Command {
  public UseBody() {
    // Use requires() here to declare subsystem dependencies
    requires( Robot.robotBody );
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double stick1 = Robot.oi.getOperatorRawAxis(1);
    double stick2 = Robot.oi.getOperatorRawAxis(5);

    double deadzone = RobotMap.OPERATE_DEADZONE;

    stick1 = ( Math.abs( stick1 ) > deadzone )? stick1 : 0;
    stick2 = ( Math.abs( stick2 ) > deadzone)? stick2 : 0;

    double elevatorValue = stick1;
    double wristValue = stick2;

    elevatorValue = Robot.robotBody.elevatorAdjustments( elevatorValue );

    Robot.robotBody.setElevator( elevatorValue );
    Robot.robotBody.setWrist( wristValue );

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.robotBody.setElevator( 0 );
    Robot.robotBody.setWrist( 0 );
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
