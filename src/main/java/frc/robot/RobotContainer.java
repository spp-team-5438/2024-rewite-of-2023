

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ClawCommand;
import frc.robot.subsystems.*;

public class RobotContainer {

  public ArmSubsystem armSubsystem;
  public LedSubsystem ledSubsystem;
  public ControllerSubsystem controllerSubsystem;
  public HandSubsystem handSubsystem;
  public DrivetrainSubsystem drivetrainSubsystem;

  public ClawCommand inOutTake;
  public ArmExtendCommand armExtendCommand;

  public RobotContainer() 
  {
    configureButtonBindings();
    handSubsystem = new HandSubsystem();
    armSubsystem = new ArmSubsystem();
    ledSubsystem = new LedSubsystem();
    drivetrainSubsystem = new DrivetrainSubsystem();
    controllerSubsystem = new ControllerSubsystem();

    armSubsystem.pivotfeedforward.calculate(20, 20, 20);
    armSubsystem.extenderfeedforward.calculate(20, 30);

    armExtendCommand = new ArmExtendCommand(armSubsystem);
    inOutTake = new ClawCommand(handSubsystem);
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
