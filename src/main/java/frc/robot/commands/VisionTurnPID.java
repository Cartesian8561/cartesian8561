/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPipelineResult;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class VisionTurnPID extends CommandBase {

  PhotonCamera camera = new PhotonCamera("MyCamera");
  DriveTrainSubsystem m_drive = new DriveTrainSubsystem();
  PhotonPipelineResult result;
  PIDController Controller = new PIDController(DriveConstants.kVisionP, 0, 0);
  public VisionTurnPID() {
    addRequirements(m_drive);
  }


  @Override
  public void execute() {
    PhotonPipelineResult result = camera.getLatestResult();
    SmartDashboard.putData("Vision PID Controller", Controller);
    double Output = Controller.calculate(result.getBestTarget().getYaw(), 0);
    m_drive.arcadeDrive(0, Output);


  }

  @Override
  public boolean isFinished() {
    return !result.hasTargets();
  }
}
