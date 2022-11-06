package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.util.Motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Robot extends SubsystemBase {

	public abstract Motor getLeftMotor();
	public abstract Motor getRightMotor();

	public abstract void stop();

}
