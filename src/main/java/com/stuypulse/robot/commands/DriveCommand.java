package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {

    private Robot robot;

    public DriveCommand(Robot robot) {
        this.robot = robot;

        addRequirements(robot);
    }

    @Override
    public void execute() {
        DriveFunctions.driveStraight(robot.getLeftMotor(), robot.getRightMotor());
    }

    @Override
    public void end(boolean interrupted) {
        robot.stop();
    }
    
}
