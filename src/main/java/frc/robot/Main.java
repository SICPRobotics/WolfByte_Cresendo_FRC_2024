// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your  main robot class, change the parameter type.
   */
  public static void main(String... args) {
     
    System.out.println("========== START PROGRAM MAIN");

 /*   
    String lname = "";
    lname = ".\\logs\\" + System.currentTimeMillis()/1000 + ".txt";
    try {
      File myObj = new File(lname);
      if (myObj.createNewFile()) {                                
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    try {
      Constants.Swerve.myWriter = new FileWriter(lname);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
     */

    RobotBase.startRobot(Robot::new);
  }
}
