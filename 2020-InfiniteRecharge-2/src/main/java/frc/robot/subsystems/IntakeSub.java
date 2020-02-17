/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {

  private CANSparkMax intake_motor = new CANSparkMax(Constants.intakemotorID,  MotorType.kBrushless);

  private DoubleSolenoid lifter = new DoubleSolenoid(Constants.compressorID, Constants.firstID, Constants.secondID);

  private DigitalInput limitswitch = new DigitalInput(Constants.limitID);

  private Compressor comp = new Compressor(Constants.compID);

  private static int count = 0;

  public IntakeSub() {

  }

  public void inTake()
  {
    intake_motor.set(1);
  }

  public void stopInTake()
  {
    intake_motor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (limitswitch.get())
      count++;
  }

  public int getCount() {
    return count;
  }
}
