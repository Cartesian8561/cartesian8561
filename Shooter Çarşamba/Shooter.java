/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  public boolean isAtSetpoint = false;

  //Shooter-Motor
  private WPI_TalonFX ShooterMotor = new WPI_TalonFX(Constants.ShooterMotorPort);

  //Encoder
  public Encoder ShooterEncoder = new Encoder(Constants.kEncoder1,Constants.kEncoder2, Constants.kEncoderisReversed);

  public Shooter() {

    ShooterEncoder.setDistancePerPulse(1.0/(Constants.kEncoderPPR));
    ShooterMotor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("SetPoint", isAtSetpoint);
    SmartDashboard.putNumber("shooter/RPM", getRPM());
  }
  public void runShooter(double val) {
    ShooterMotor.set(val);
  }

  public void runShooterVoltage(double voltage) {
    ShooterMotor.setVoltage(voltage);
  }

  public double getRPM() {
    return ShooterEncoder.getRate() * 60;
  }
}
