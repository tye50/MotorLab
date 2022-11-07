package com.stuypulse.robot.util;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import com.stuypulse.robot.constants.Settings.Limits;

import edu.wpi.first.math.util.Units;

public class SimMotor implements Motor {

    private final DoubleConsumer setVoltage;
    private final DoubleSupplier speed;
    private final DoubleSupplier distance;

    public SimMotor(DoubleConsumer setVoltage, DoubleSupplier speed, DoubleSupplier distance) {
        this.setVoltage = setVoltage;
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public void set(double speed) {
        setVoltage.accept(speed * Limits.ROMI_MAX_VOLTS);
    }

    @Override
    public double getSpeed() {
        return Units.metersToInches(speed.getAsDouble());
    }

    @Override
    public double getDistance() {
        return Units.metersToInches(distance.getAsDouble());
    }
    
}
