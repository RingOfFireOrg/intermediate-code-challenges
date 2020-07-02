/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Joystick rightStick;
  Joystick leftStick;

  JoystickButton shooterButton;
  JoystickButton transferButton;
  JoystickButton intakeButton;

  WPI_TalonSRX shooterMotor;
  WPI_TalonSRX transferMotor;
  WPI_TalonSRX intakeMotor;
  WPI_TalonSRX rightDriveMotor;
  WPI_TalonSRX leftDriveMotor;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    rightStick = new Joystick(1);
    leftStick = new Joystick(2);

    shooterButton = new JoystickButton(rightStick, 1);
    transferButton = new JoystickButton(rightStick, 2);
    intakeButton = new JoystickButton(rightStick, 3);

    shooterMotor = new WPI_TalonSRX(0);
    transferMotor = new WPI_TalonSRX(1);
    intakeMotor = new WPI_TalonSRX(2);
    rightDriveMotor = new WPI_TalonSRX(3);
    leftDriveMotor = new WPI_TalonSRX(4);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopPeriodic() {
    if (shooterButton.get()){
      shooterMotor.set(0.95);
    }

    if (transferButton.get()){
      transferMotor.set(0.4);
    }

    if (intakeButton.get()){
      intakeMotor.set(0.8);
    }

    rightDriveMotor.set(rightStick.getY());
    leftDriveMotor.set(leftStick.getY());
  }

  @Override
  public void testPeriodic() {
  }
}
