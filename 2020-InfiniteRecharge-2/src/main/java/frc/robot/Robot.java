/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ClimbDownLeftCommand;
import frc.robot.commands.ClimbDownRightCommand;
import frc.robot.commands.ClimbUpLeftCommand;
import frc.robot.commands.ClimbUpRightCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.ClimbSub;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.IntakeSub;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public final DriveTrainSub drivetrainsub = new DriveTrainSub();
  private RobotContainer m_robotContainer;
  private ClimbSub climbsub1 = new ClimbSub(Constants.rackone); //creates the right motor subsystem
  private ClimbSub climbsub2 = new ClimbSub(Constants.racktwo); //creates the left motor subsystem
  private ClimbUpRightCommand climbuprightcommand = new ClimbUpRightCommand(climbsub1); //creates the right climb up command
  private ClimbUpLeftCommand climbupleftcommand = new ClimbUpLeftCommand(climbsub2); //creates the left climb up command
  private ClimbDownRightCommand climbdownrightcommand = new ClimbDownRightCommand(climbsub1); //creates the right climb down command
  private ClimbDownLeftCommand climbdownleftcommand = new ClimbDownLeftCommand(climbsub2);
  private Joystick driver = new Joystick(0);  //creates the controller
  private Joystick operator = new Joystick(1);//logitech gamepad
  private IntakeSub intakesub = new IntakeSub();
  private IntakeCommand intakecommand = new IntakeCommand(intakesub);
  
   


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {

    drivetrainsub.Drive(-(operator.getRawAxis()), ope); //TODO fix this line of code

    if(operator.getRawButtonPressed(Constants.intake) && intakecommand.getCount() <= 5)
    {
      intakecommand.inTake();
    }
    else
      {
        intakecommand.stopInTake();
      }
    //this checks if the button is pressed and if the encoder values are too low or too high
    //if statement to check if you can climb up or down
    if(operator.getRawButtonPressed(Constants.climbupright) && climbsub1.getEncoder() < Constants.maxencodervalue)
    {
      climbuprightcommand.climb();
    }
    else
    {
      climbuprightcommand.stopClimb();
    }

    if(operator.getRawButtonPressed(Constants.climbupleft) && climbsub2.getEncoder() < Constants.maxencodervalue)
    {
      climbupleftcommand.climb();
    }

    else
    {
      climbupleftcommand.stopClimb();
    }

    if(operator.getRawButtonPressed(Constants.climbdownleft) && climbsub2.getEncoder() < Constants.minencodervalue)
    {
      climbdownleftcommand.climb();
    }

    else
    {
      climbdownleftcommand.stopClimb();
    }

    if(operator.getRawButtonPressed(Constants.climbdownright) && climbsub1.getEncoder() < Constants.minencodervalue)
    {
      climbdownrightcommand.climb();
    }

    else
    {
      climbdownrightcommand.stopClimb();
    }
    
  }
}
