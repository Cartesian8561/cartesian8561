/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShooterVision extends PIDCommand {
  /**
   * Creates a new SetShooterRpm.
   */
  private Shooter m_shooter;
  private final static ShooterVision m_shooterFeedForward = new SimpleMotorFeedforward(Constants.kS,
      Constants.kV,Constants.kA);
  private static double m_motorOutput;
  private boolean isInterruptable;
  public double distance;
  public PhotonCamera m_camera;

  public static double targetRPM;

  public ShooterVision(final Shooter shooter, final boolean _isInterruptable, PhotonCamera camera) {
    super(new PIDController(Constants.kShootP, Constants.kShootI, Constants.kShootD),
        // This should return the measurement
        shooter::getRPM,
        // This should return the setpoint (can also be a constant)
        targetRPM,
        // This uses the output
        output -> {
          // Use the output here
          m_motorOutput = output + m_shooterFeedForward.calculate(targetRPM);
          shooter.runShooterVoltage(m_motorOutput);
        });
    m_shooter = shooter;
    m_camera = camera;
    this.isInterruptable = _isInterruptable;
    addRequirements(m_shooter);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    targetRPM = calcuateRPM();
    super.initialize(); // initalized and set
    m_motorOutput = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    super.execute();
    m_shooter.isAtSetpoint = getController().atSetpoint();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    super.end(interrupted);
    if (!isInterruptable) {
      m_shooter.runShooterVoltage(0);
      m_shooter.isAtSetpoint = false;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (isInterruptable && getController().atSetpoint()) { // Finishes if it is allowed to finish
      return true;
    } else {
      return false;
    }
  }

  public double calcuateRPM(){
    var result = m_camera.getLatestResult();
    distance = PhotonUtils.calculateDistanceToTargetMeters(Constants.CAMERA_HEIGHT_METERS, Constants.TARGET_HEIGHT_METERS,
                  Constants.CAMERA_PITCH_RADIANS, result.getBestTarget().getPitch());
    double target = distance*Constants.a + Constants.b;
    return target;
  }
}
