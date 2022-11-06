/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {
    public interface Limits {
        int CAN_MAX_VOLTS = 8;

        int ROMI_MAX_VOLTS = 8;
    }

    public interface Romi {
        public interface Robot {
            double TRACK_WIDTH_METERS = 0.141;
            double WHEEL_DIAMETER_METERS = 0.070;
        }
        
        public interface Encoder {
            double COUNTS_PER_REVOLUTION = 1440.0;
        }
    }
}
