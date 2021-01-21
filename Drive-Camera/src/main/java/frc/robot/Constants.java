/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.util.Units;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   final static double CAMERA_HEIGHT_METERS = Units.inchesToMeters(24);
   final static double TARGET_HEIGHT_METERS = Units.feetToMeters(5);
   final static double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);
   final static double GOAL_RANGE_METERS = Units.feetToMeters(3);
   final static int kDriverControllerPort = 0;
}
