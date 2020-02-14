/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrainSub extends SubsystemBase {
  /**
   * Creates a new TEST.
   */
  private CANSparkMax front_right = new CANSparkMax(Constants.dm_motorrightID, MotorType.kBrushless);
  private CANSparkMax front_left = new CANSparkMax(Constants.dm_motorleftID, MotorType.kBrushless);
  private CANSparkMax back_right = new CANSparkMax(Constants.dm_rightfollowerID, MotorType.kBrushless);
  private CANSparkMax back_left = new CANSparkMax(Constants.dm_leftfollowerID, MotorType.kBrushless);

  SpeedControllerGroup mLeft = new SpeedControllerGroup(front_left, back_left);
  SpeedControllerGroup mRight = new SpeedControllerGroup(front_right, back_right);

  DifferentialDrive allRobot = new DifferentialDrive(mLeft,mRight);

  public DriveTrainSub() 
  {
    

  }

  public void Drive(int y, int x)
  {
    allRobot.arcadeDrive(-y,x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
