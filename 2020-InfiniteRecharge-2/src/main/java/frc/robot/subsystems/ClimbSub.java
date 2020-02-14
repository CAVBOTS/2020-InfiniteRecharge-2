/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSub extends SubsystemBase {
 
  public CANSparkMax climbmotor;
  private CANEncoder m_encoder;

  public ClimbSub(int x)
  {

    climbmotor = new CANSparkMax(x , MotorType.kBrushless);

  }

  public ClimbSub() {

  }

  public double getEncoder()
  {
    m_encoder = climbmotor.getEncoder();
    double encodervalue = m_encoder.getPosition();
    return encodervalue;
  }

  public void climbUp()
  {
    climbmotor.set(1);
  }

  public void climbDown()
  {
    climbmotor.set(-1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
