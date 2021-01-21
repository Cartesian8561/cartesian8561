/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  TalonSRX leftmotor1 = new TalonSRX(1);
  TalonSRX rightmotor1 = new TalonSRX(0);
  TalonSRX leftmotor2 = new TalonSRX(3);
  TalonSRX rightmotor2 = new TalonSRX(4);
  public Drive() {
    final SpeedControllerGroup leftMotors =
      new SpeedControllerGroup(new PWMVictorSPX(0),
                               new PWMVictorSPX(1));

  // The motors on the right side of the drive.
    final SpeedControllerGroup rightMotors =
      new SpeedControllerGroup(new PWMVictorSPX(2),
                               new PWMVictorSPX(3));

  // The robot's drive
    final DifferentialDrive m_drive = new DifferentialDrive(leftMotors,rightMotors);

  // The left-side drive encoder
    //final Encoder leftEncoder =
      //new Encoder(DriveConstants.kLeftEncoderPorts[0], DriveConstants.kLeftEncoderPorts[1],
                 //DriveConstants.kLeftEncoderReversed);

  // The right-side drive encoder
  //private final Encoder m_rightEncoder =
      //new Encoder(DriveConstants.kRightEncoderPorts[0], DriveConstants.kRightEncoderPorts[1],
                  //DriveConstants.kRightEncoderReversed);

  // The gyro sensor
  //private final Gyro m_gyro = new ADXRS450_Gyro();

  // Odometry class for tracking robot pose
  //private final DifferentialDriveOdometry m_odometry;

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
