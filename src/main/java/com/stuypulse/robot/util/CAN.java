package com.stuypulse.robot.util;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.stuypulse.robot.constants.Settings.Limits;

public class CAN implements Motor {

    private CANSparkMax[] motors;
    private RelativeEncoder encoder;

    public CAN(CANSparkMax... motors) {
        this.motors = motors;
        
        encoder = motors[0].getEncoder();
    }

    @Override
    public void set(double speed) {
        for (CANSparkMax motor : motors) {
            motor.setVoltage(speed * Limits.CAN_MAX_VOLTS);
        }
    }

    @Override
    public double getSpeed() {
        return encoder.getVelocity();
    }

    @Override
    public double getDistance() {
        return encoder.getPosition();
    }

}
