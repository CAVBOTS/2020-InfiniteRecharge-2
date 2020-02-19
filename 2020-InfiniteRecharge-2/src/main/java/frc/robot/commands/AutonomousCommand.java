package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LimeLightSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.AimCommand;

public class AutonomousCommand extends CommandBase {
    /**
     * Creates a new LimeLight.
     */
    private LimeLightSubsystem lime;
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    private CANSparkMax leftFollower;
    private CANSparkMax rightFollower;
    private AimCommand aim;// = new AimCommand(null, leftFollower, leftFollower, leftFollower, leftFollower);

    
  
    public AutonomousCommand(CANSparkMax front_right, CANSparkMax front_left, CANSparkMax back_right, CANSparkMax back_left)
     {
        leftMotor = front_left;
        rightMotor = front_right;
        leftFollower = back_left;
        rightFollower = back_right;
      // Use addRequirements() here to declare subsystem dependencies.
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

        //initialize motors
        
        aim = new AimCommand(lime, leftMotor, rightMotor, leftFollower, rightFollower);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if(lime.getta().getDouble(0)>.8){ //TODO determine area
        leftMotor.set(0);
        rightMotor.set(0);
        leftFollower.follow(leftMotor);
        rightFollower.follow(rightMotor);
        aim.aime();
      }
      else{
        leftMotor.set(0.2);
        rightMotor.set(0.2);
        leftFollower.follow(leftMotor);
        rightFollower.follow(rightMotor);
      }
        
    // leftMotor.set(0);
    // rightMotor.set(0);
    // leftFollower.follow(leftMotor);
    // rightFollower.follow(rightMotor);
      
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    leftMotor.set(0);
    rightMotor.set(0);
    leftFollower.follow(leftMotor);
    rightFollower.follow(rightMotor);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }