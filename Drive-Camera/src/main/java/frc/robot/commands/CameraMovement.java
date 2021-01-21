/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class CameraMovement extends CommandBase {

  private final Drive m_drive;
  /**
   * Creates a new CameraMovement.
   */
  PhotonCamera camera = new PhotonCamera("photonvision");

  final double LINEAR_P = 0.1; // Bunları ayarlamak gerek -
  final double LINEAR_D = 0.0;
  

  final double ANGULAR_P = 0.1;
  final double ANGULAR_D = 0.0;
  
  double forwardSpeed = 0;
  double rotationSpeed = 0;
  
  public CameraMovement() {

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    PIDController turnController = new PIDController(ANGULAR_P, 0, ANGULAR_D);
    PIDController forwardController = new PIDController(LINEAR_P, 0, LINEAR_D);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    var result = camera.getLatestResult();

    double range = PhotonUtils.calculateDistanceToTargetMeters(CAMERA_HEIGHT_METERS, TARGET_HEIGHT_METERS,
    CAMERA_PITCH_RADIANS, result.getBestTarget().getPitch());

    forwardSpeed = forwardController.calculate(range, GOAL_RANGE_METERS);
    rotationSpeed = turnController.calculate(result.getBestTarget().getYaw(), 0);

    drive.arcadeDrive(forwardSpeed, rotationSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    forwardSpeed = 0;
    rotationSpeed = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return result.hasTargets();
  }
}
