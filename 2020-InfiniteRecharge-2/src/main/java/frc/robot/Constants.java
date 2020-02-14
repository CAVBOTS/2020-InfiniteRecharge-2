/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //initialize CAN IDS
    public final static int PDP = 0;

    //drivetrain motors
    public final static int dm_motorleftID = 1;
    public final static int dm_leftfollowerID = 2;
    public final static int dm_motorrightID = 3;
    public final static int dm_rightfollowerID = 4;

    //launcher motors
    public static final int rotorymotorID = 5;
    public static final int wheelmotorID = 6;

    //Colorwheel
    public static final int colormotorID = 7;

    //intake motors
    public static final int intakemotorID = 8;
    public static final int intakefollowerID = 9;

    //Rack and pinion motors
    public final static int rackone = 10;//right motor
    public final static int racktwo = 11;//left motor
    public final static int maxencodervalue = 8; // used in the if statement to check max height 
    public final static int minencodervalue = -8; // used in the if statemnt to check the min height

    //elevator motors
    public static final int e_leftmotorID = 12;
    public static final int e_rightmotorID = 13;

    //hanging motors
    public static final int hangmotorID = 14;
    public static final int hangfollowerID = 15;

    // declares x and y in drive method in drive train sub
    public final static int drivey = 5;
    public final static int drivex = 5;


}
