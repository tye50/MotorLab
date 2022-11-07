package com.stuypulse.robot.util;

import com.stuypulse.robot.constants.Settings.Limits;
import com.stuypulse.stuylib.streams.filters.LowPassFilter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class RomiMotor extends Motor {

    private Spark motor;
    private Encoder encoder;

    private double targetSpeed;
    private LowPassFilter filter;

    public RomiMotor(Spark motor, Encoder encoder) {
        this.motor = motor;
        this.encoder = encoder;

        targetSpeed = 0;
        filter = new LowPassFilter(0.2);
    }

    @Override
    public void set(double speed) {
        targetSpeed = speed;
    }

    @Override
    public double getSpeed() {
        return encoder.getRate();
    }

    @Override
    public double getDistance() {
        return encoder.getDistance();
    }

    @Override
    public void periodic() {
        motor.setVoltage(filter.get(targetSpeed) * Limits.ROMI_MAX_VOLTS);
    }
    
}
