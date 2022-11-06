package com.stuypulse.robot.util;

import com.stuypulse.robot.constants.Settings.Limits;
import com.stuypulse.robot.constants.Settings.Romi;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class RomiMotor implements Motor {

    private Spark motor;
    private Encoder encoder;

    public RomiMotor(Spark motor, Encoder encoder) {
        this.motor = motor;
        this.encoder = encoder;

        // set encoder units to be rotations
        encoder.setDistancePerPulse(1.0 / Romi.Encoder.COUNTS_PER_REVOLUTION);
    }

    @Override
    public void set(double speed) {
        motor.setVoltage(speed * Limits.ROMI_MAX_VOLTS);
    }

    @Override
    public double getSpeed() {
        return encoder.getRate();
    }

    @Override
    public double getDistance() {
        return encoder.getDistance();
    }
    
}
