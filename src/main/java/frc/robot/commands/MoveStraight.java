/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveStraight extends Command {
  
  public double rotationsToGoRight;
  public double rotationsToGoLeft;
  public double speed;
  public double averagePosition;
  public double rotationsToGo;

  private boolean isFinished;

  public MoveStraight( double rotationsInput, double speedInput ) {
   
    speed = speedInput;

    rotationsToGo = (speed > 0)? rotationsInput: -rotationsInput;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires( Robot.driveTrain );

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    rotationsToGoRight = Robot.driveTrain.getRightMotorsPosition() + rotationsToGo;
    rotationsToGoLeft =  Robot.driveTrain.getLeftMotorsPosition() + rotationsToGo;

    isFinished = false;

    Robot.driveTrain.setLeftMotors( speed );
    Robot.driveTrain.setRightMotors( speed );
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rotationsGoneLeft = Robot.driveTrain.getLeftMotorsPosition();
    double rotationsGoneRight = Robot.driveTrain.getRightMotorsPosition();

    System.out.println( averagePosition );
    System.out.println( rotationsToGoLeft + ", " + rotationsGoneLeft);
    if( Robot.oi.bButton1.get() || speed >= 0 && ( rotationsGoneLeft >= rotationsToGoLeft || rotationsGoneRight >= rotationsToGoRight ) || speed < 0 && ( rotationsGoneLeft <= rotationsToGoLeft || rotationsGoneRight <= rotationsToGoRight ) ){
      this.end();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotors( 0 );
    Robot.driveTrain.setRightMotors( 0 );
    isFinished = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
