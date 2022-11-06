// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.stuypulse.robot.subsystems;

import static com.stuypulse.robot.constants.Ports.Romi.*;
import static com.stuypulse.robot.constants.Settings.Romi.Robot.*;
import static com.stuypulse.robot.constants.Settings.Romi.Encoder.*;

import com.stuypulse.robot.util.Motor;
import com.stuypulse.robot.util.RomiMotor;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Romi extends Robot {
  
  private Spark leftMotor = new Spark(LEFT_MOTOR);
  private Spark rightMotor = new Spark(RIGHT_MOTOR);

  private Encoder leftEncoder = new Encoder(LEFT_ENCODER_A, LEFT_ENCODER_B);
  private Encoder rightEncoder = new Encoder(RIGHT_ENCODER_A, RIGHT_ENCODER_B);

  private final DifferentialDriveOdometry odometry;
  private final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(TRACK_WIDTH_METERS);
  
  private final RomiGyro gyro = new RomiGyro();

  private final Field2d field = new Field2d();

  /** Creates a new RomiDrivetrain. */
  public Romi() {
    leftEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
    rightEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);

    leftEncoder.reset();
    rightEncoder.reset();

    // Invert right side since motor is flipped
    rightMotor.setInverted(true);

    odometry = new DifferentialDriveOdometry(getRotation2d());

    SmartDashboard.putData(field);
  }

  public Pose2d getPose() {
    return odometry.getPoseMeters();
  }

  public Rotation2d getRotation2d() {
    return new Rotation2d((rightEncoder.getDistance() - rightEncoder.getDistance()) / TRACK_WIDTH_METERS);
  }

  @Override
  public Motor getLeftMotor() {
    return new RomiMotor(leftMotor, leftEncoder);
  }

  @Override
  public Motor getRightMotor() {
    return new RomiMotor(rightMotor, rightEncoder);
  }

  @Override
  public void stop() {
    leftMotor.stopMotor();
    rightMotor.stopMotor();
  }

  @Override
  public void periodic() {
    odometry.update(getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
    field.setRobotPose(getPose());
  }
}
