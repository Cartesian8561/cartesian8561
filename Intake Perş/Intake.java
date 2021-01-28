/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private static final WPI_TalonFX intakeMotor = new WPI_TalonFX(IntakeConstants.kIntakeMotorPort);
  private boolean intakeStatus = false;
  private Solenoid IntakeSolenoid = new Solenoid(IntakeConstants.kSolenoidPort); //Assuming that we use a single solenoid
  public boolean solenoidstate = false;

  public Intake(){}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("intakeStatus", intakeStatus);
  }

  public void runIntake(double speed){
    intakeMotor.set(speed);
  }

  public void stopIntake() {
    intakeMotor.set(0);
  }
  public void openSolenoid(){
    IntakeSolenoid.set(true);
  }
  public void closeSolenoid(){
    IntakeSolenoid.set(false);
  }
}