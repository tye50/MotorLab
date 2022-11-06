package com.stuypulse.robot.util;

public interface Motor {
    // set speed from -1.0 to 1.0
    public void set(double speed);

    // speed in m/s
    public double getSpeed();

    // distance in m
    public double getDistance();
}
