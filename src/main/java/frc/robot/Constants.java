// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Joystick IDs
    public static final int joystickport=0;
    public static final int xaxis=0;
    public static final int yaxis=1;

    public static final class DriveConstants{

    //Motor IDs
        public static final int kLeft1_id=0;
        public static final int kLeft2_id=0;
        public static final int kRight1_id=0;
        public static final int kRight2_id=0;

    //Encoder IDs
    public static final double kEncoderSPR = 0;
	public static final double wheelDiameter = 0;
	public static final double kMaxSpeedMetersPerSecond = 0;
	public static final double kMaxAccelerationMetersPerSecondSquared = 0;
	public static double kVisionP; // Characterization required--



    



    }

}
