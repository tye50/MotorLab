package com.stuypulse.robot.commands;

import com.stuypulse.robot.util.Motor;

// ctr shift p --> WPILIB: build robot code --> WPILIB: simulate robot code --> make sure to check all the boxes

public class DriveFunctions {
    
    public static void driveForwards(Motor left, Motor right) {
        left.set(1.0);
        right.set(1.0);
    }

    public static void driveBackwards(Motor left, Motor right) {
        left.set(-1.0);
        right.set(-1.0);
    }

    public static void turnRight(Motor left, Motor right) {
        // make one wheel turn and the other stays 
        left.set(1.0);
        right.set(0.0);
    }

    public static void turnLeft(Motor left, Motor right) {
        left.set(0.0);
        right.set(1.0);
    }

    public static void arcRight(Motor left, Motor right) {
        left.set(1.0);
        right.set(0.5);
    }

    public static void arcLeft(Motor left, Motor right) {
        left.set(0.5);
        right.set(1.0);
    }

    public static void stopDistance(Motor left, Motor right) {
        double setpoint = 60.0;
        left.set(1.0);
        right.set(1.0);
        if (left.getDistance() >= setpoint) {
            left.set(0.0);
            right.set(0.0);
        }
    }

    public static void bangBang(Motor left, Motor right) {
        double setpoint = 60.0;
        // if statements are always running so move forward has to 
        // be in the else
        if (left.getDistance() >= setpoint) {
            left.set(-1.0);
            right.set(-1.0);
        }
        else {
            left.set(1.0);
            right.set(1.0);
        }
    }

    public static void lessBang(Motor left, Motor right) {
        double setpoint = 60.0;
        if (left.getDistance() < setpoint/2) {
            left.set(1.0);
            right.set(1.0);
        }
        else if (left.getDistance() >= setpoint/2 && left.getDistance() <= setpoint) {
            left.set(0.5);
            right.set(0.5);
        }
        else {
            left.set(-1.0);
            right.set(-1.0);
        }
    }

    public static void betterControl(Motor left, Motor right) {
        double setpoint = 60.0;
        double measurement = left.distance();
        double error = setpoint - measurement; // error decreases over time

        double speed = error/setpoint;
        left.set(speed);
        right.set(speed);
        
    }

    public static void bestestControl(Motor left, Motor right) {
        return;
    }
}
