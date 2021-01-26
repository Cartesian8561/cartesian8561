// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrainSubsystem extends SubsystemBase {
  //Motor Identification
  WPI_TalonFX left1motor = new WPI_TalonFX(DriveConstants.kLeft1_id);
  WPI_TalonFX left2motor = new WPI_TalonFX(DriveConstants.kLeft2_id);
  WPI_TalonFX right1motor = new WPI_TalonFX(DriveConstants.kRight1_id);
  WPI_TalonFX right2motor = new WPI_TalonFX(DriveConstants.kRight2_id);
  
  //Gyro Identification
  Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
  private final DifferentialDrive m_drive = new DifferentialDrive(left1motor, right1motor);

  public DriveTrainSubsystem() {
    
    //Motor Connection
    left2motor.follow(left1motor);
    right2motor.follow(right1motor);
    left1motor.setInverted(false);
    right1motor.setInverted(false);

    //Encoder Identification
    left1motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,10);
    right1motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  } 
}



