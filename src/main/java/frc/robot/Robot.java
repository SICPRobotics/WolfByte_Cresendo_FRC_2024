// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
/*data log imports */
import edu.wpi.first.util.datalog.BooleanLogEntry;
import edu.wpi.first.util.datalog.DataLog;
import edu.wpi.first.util.datalog.DoubleLogEntry;
import edu.wpi.first.util.datalog.StringLogEntry;
import edu.wpi.first.wpilibj.DataLogManager;

import com.ctre.phoenix6.configs.AudioConfigs;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Orchestra ourOrchestra;

  TalonFX musicTalon1; 
  //TalonFX musicTalon2 = new TalonFX(2);
  //TalonFX musicTalon3 = new TalonFX(3);
  //TalonFX musicTalon4 = new TalonFX(4);
  //TalonFX musicTalon5 = new TalonFX(5);
  //TalonFX musicTalon6 = new TalonFX(6);
  //TalonFX musicTalon7 = new TalonFX(7);
  //TalonFX musicTalon8 = new TalonFX(8);
  

  public static final CTREConfigs ctreConfigs = new CTREConfigs();

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  StringLogEntry testLogEntry;
  
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    ourOrchestra = new Orchestra();

    musicTalon1 = new TalonFX(14); 
  //TalonFX musicTalon2 = new TalonFX(2);
  //TalonFX musicTalon3 = new TalonFX(3);
  //TalonFX musicTalon4 = new TalonFX(4);
  //TalonFX musicTalon5 = new TalonFX(5);
  //TalonFX musicTalon6 = new TalonFX(6);
  //TalonFX musicTalon7 = new TalonFX(7);
  //TalonFX musicTalon8 = new TalonFX(8);

    //m_robotContainer = new RobotContainer();

    DataLogManager.start();
    DataLogManager.log("Why no workie work?????");
    DataLog log = DataLogManager.getLog();
    testLogEntry = new StringLogEntry(log, "/testinglog/stringlog");
    
    System.out.println("========== INITIALIZING ROBOT");
   

        ourOrchestra.addInstrument(musicTalon1);
   // ourOrchestra.addInstrument(musicTalon2);
   // ourOrchestra.addInstrument(musicTalon3);
   // ourOrchestra.addInstrument(musicTalon4);
   // ourOrchestra.addInstrument(musicTalon5);
   // ourOrchestra.addInstrument(musicTalon6);
   // ourOrchestra.addInstrument(musicTalon7);
   // ourOrchestra.addInstrument(musicTalon8); 

   
    AudioConfigs letmeadjust = new AudioConfigs();
    letmeadjust.AllowMusicDurDisable = true;

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
   // m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

 

    var didWork = ourOrchestra.loadMusic("song1.chrp");

      if(!didWork.isOK()){
        System.out.println("did not work :(");
      }
      else{
        System.out.println("it worked!");
      }

      ourOrchestra.play();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
