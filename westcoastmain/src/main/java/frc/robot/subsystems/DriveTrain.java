/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

   public TalonSRX rightmotor = null;
   public TalonSRX leftmotor = null;
   DifferentialDrive differentialDrive;
   SpeedControllerGroup leftside; 
   SpeedControllerGroup rightside; 
  public DriveTrain() {
    rightmotor = new TalonSRX(Constants.rightnummer);
    leftmotor = new TalonSRX(Constants.leftnummer);
    
    rightside = new SpeedControllerGroup(rightmotor, rightmotor);
    leftside = new SpeedControllerGroup(leftmotor, leftmotor);

    differentialDrive = new DifferentialDrive(leftside, rightside):
    

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setmotorspeeds(double linear, double rotation){
    leftmotor.set(ControlMode.PercentOutput, linear+rotation);
    rightmotor.set(ControlMode.PercentOutput, -linear-rotation);
  }
}
