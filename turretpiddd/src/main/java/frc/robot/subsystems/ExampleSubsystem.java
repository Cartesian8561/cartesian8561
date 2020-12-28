/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExampleSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  TalonSRX turner = null;
  TalonSRX lifter = null;

  public ExampleSubsystem() { 
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
