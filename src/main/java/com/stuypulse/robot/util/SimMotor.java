package com.stuypulse.robot.util;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import com.stuypulse.robot.constants.Settings.Limits;
import com.stuypulse.stuylib.streams.filters.LowPassFilter;

import edu.wpi.first.math.util.Units;

public class SimMotor extends Motor {

    private final DoubleConsumer setVoltage;
    private final DoubleSupplier speed;
    private final DoubleSupplier distance;

    private double targetSpeed;
    private LowPassFilter filter;

    public SimMotor(DoubleConsumer setVoltage, DoubleSupplier speed, DoubleSupplier distance) {
        this.setVoltage = setVoltage;
        this.speed = speed;
        this.distance = distance;

        targetSpeed = 0;
        filter = new LowPassFilter(0.2);
    }

    @Override
    public void set(double speed) {
        targetSpeed = speed;
    }

    @Override
    public double getSpeed() {
        return Units.metersToInches(speed.getAsDouble());
    }

    @Override
    public double getDistance() {
        return Units.metersToInches(distance.getAsDouble());
    }

    @Override
    public void periodic() {
        setVoltage.accept(filter.get(targetSpeed) * Limits.ROMI_MAX_VOLTS);
    }
    
}
