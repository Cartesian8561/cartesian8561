package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  TalonSRX turner = null;
  TalonSRX lifter = null;

  public Turret() { 
    turner = new TalonSRX(Constants.turnernummer);
    lifter = new TalonSRX(Constants.lifternummer);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setturnerspeed(double outputspeed){
turner.set(ControlMode.PercentOutput, outputspeed);

  }
  public void setlifterspeed(double outputspeed){
    lifter.set(ControlMode.PercentOutput, outputspeed);
    
      }
}
