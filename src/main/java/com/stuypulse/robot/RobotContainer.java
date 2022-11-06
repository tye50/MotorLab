/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot;

import com.stuypulse.robot.commands.DriveFunctions;
import com.stuypulse.robot.commands.MotorCommand;
import com.stuypulse.robot.subsystems.SimRomi;
import com.stuypulse.robot.subsystems.Robot;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.keyboard.SimKeyGamepad;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    // Gamepads
    public final Gamepad driver = new SimKeyGamepad();
    
    // Subsystem
    private Robot robot = new SimRomi();

    // Autons
    private static SendableChooser<Command> autonChooser = new SendableChooser<>();

    // Robot container

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
        configureAutons();
    }

    /****************/
    /*** DEFAULTS ***/
    /****************/

    private void configureDefaultCommands() {}

    /***************/
    /*** BUTTONS ***/
    /***************/

    private void configureButtonBindings() {}

    /**************/
    /*** AUTONS ***/
    /**************/

    public void configureAutons() {
        autonChooser.setDefaultOption("Drive Forwards", new MotorCommand(robot, DriveFunctions::driveForwards));
        autonChooser.addOption("Drive Backwards", new MotorCommand(robot, DriveFunctions::driveBackwards));
        autonChooser.addOption("Turn Clockwise", new MotorCommand(robot, DriveFunctions::turnClockwise));

        SmartDashboard.putData("Autonomous", autonChooser);
    }

    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }
}
